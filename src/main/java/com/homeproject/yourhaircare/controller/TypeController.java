package com.homeproject.yourhaircare.controller;


import com.homeproject.yourhaircare.service.TypeService;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public List<TypeDto> getAllTypes() {
        return typeService.getAllTypes();
    }
}
