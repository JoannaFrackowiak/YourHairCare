package com.homeproject.yourhaircare.controller;

import com.homeproject.yourhaircare.service.CosmeticService;
import com.homeproject.yourhaircare.service.UserService;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateAndChangeCosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateUpdateUserDto;
import com.homeproject.yourhaircare.service.dto.UserDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserDto addNewUser(@RequestBody CreateUpdateUserDto createUpdateUserDto)
            throws BadRequest, AlreadyExists {
        return userService.addNewUser(createUpdateUserDto);
    }
}
