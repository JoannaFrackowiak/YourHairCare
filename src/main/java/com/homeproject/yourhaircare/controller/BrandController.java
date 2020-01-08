package com.homeproject.yourhaircare.controller;

import com.homeproject.yourhaircare.service.BrandService;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }
}
