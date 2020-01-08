package com.homeproject.yourhaircare.controller;


import com.homeproject.yourhaircare.service.FeatureService;
import com.homeproject.yourhaircare.service.dto.FeatureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public List<FeatureDto> getAllFeatures() {
        return featureService.getAllFeatures();
    }
}
