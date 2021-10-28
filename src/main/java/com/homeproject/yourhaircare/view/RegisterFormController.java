package com.homeproject.yourhaircare.view;

import com.homeproject.yourhaircare.controller.UserController;
import com.homeproject.yourhaircare.service.dto.CreateUpdateUserDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
//@Validated
public class RegisterFormController implements WebMvcConfigurer {

    @Autowired
    private UserController userController;

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home-page").setViewName("home-page");
//    }

    @GetMapping("/register-form")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("register-form");
        CreateUpdateUserDto createUpdateUserDto = new CreateUpdateUserDto();
        modelAndView.addObject("userForm", createUpdateUserDto);
        return modelAndView;
    }

    @PostMapping("/register-user")
    public String addNewUser(@Valid @ModelAttribute("createUpdateUserDto") CreateUpdateUserDto createUpdateUserDto,
                             BindingResult bindingResult, Model model) throws AlreadyExists, BadRequest {
        if (bindingResult.hasErrors()) {
//            List<ObjectError> errorsList = bindingResult.getAllErrors();
//            for(ObjectError error:errorsList) {
//                System.out.println(error);
//            }
            return "register-form";
        }
        userController.addNewUser(createUpdateUserDto);
        return "redirect:/home-page";
    }

    @GetMapping("/index")
    public ModelAndView startPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }




}
