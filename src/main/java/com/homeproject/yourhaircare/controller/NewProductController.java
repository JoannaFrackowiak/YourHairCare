package com.homeproject.yourhaircare.controller;

import com.homeproject.yourhaircare.service.NewProductsService;
import com.homeproject.yourhaircare.service.dto.CreateUpdateNewProductDto;
import com.homeproject.yourhaircare.service.dto.NewProductDto;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/newProducts")
public class NewProductController {

    @Autowired
    private NewProductsService newProductsService;

    @PostMapping
    public NewProductDto createNewProduct(@RequestBody CreateUpdateNewProductDto dto) throws BadRequest {
        return newProductsService.createNewProduct(dto);
    }
}
