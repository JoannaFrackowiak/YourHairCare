package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.repository.BrandRepository;
import com.homeproject.yourhaircare.repository.FeatureRepository;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import com.homeproject.yourhaircare.service.dto.FeatureDto;
import com.homeproject.yourhaircare.service.mapper.BrandMapper;
import com.homeproject.yourhaircare.service.mapper.FeatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private FeatureMapper featureMapper;

    @Transactional
    public List<FeatureDto> getAllFeatures() {
        return featureRepository.findAll()
                .stream()
                .map(brand -> featureMapper.toDto(brand))
                .collect(Collectors.toList());
    }
}
