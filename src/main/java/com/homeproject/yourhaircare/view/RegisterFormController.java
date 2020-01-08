package com.homeproject.yourhaircare.view;

import com.homeproject.yourhaircare.controller.UserController;
import com.homeproject.yourhaircare.service.dto.CreateUpdateUserDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterFormController {

    @Autowired
    private UserController userController;

    @GetMapping("/register-form")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("register-form");
        CreateUpdateUserDto createUpdateUserDto = new CreateUpdateUserDto();
        modelAndView.addObject("userForm", createUpdateUserDto);
        return modelAndView;
    }

    @PostMapping("/register-user")
    public String addNewUser(@ModelAttribute CreateUpdateUserDto newUserDto) throws BadRequest, AlreadyExists {
        userController.addNewUser(newUserDto);
        return "redirect:/home-page";
    }

}
