package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.repository.FeatureRepository;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.FeatureDto;
import com.homeproject.yourhaircare.service.exception.NotFound;
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

    public List<FeatureDto> getAllFeaturesForUser(List<CosmeticDto> cosmeticDtoList) {
        return cosmeticDtoList.stream()
                .map(cosmeticDto -> cosmeticDto.getFeatureId())
                .map(id -> featureRepository.findFeatureById(id))
                .map(feature -> featureMapper.toDto(feature))
                .collect(Collectors.toList());
    }

    @Transactional
    public FeatureDto getFeature(Long id) throws NotFound {
        return featureRepository.findById(id)
                .map(feature -> featureMapper.toDto(feature))
                .orElseThrow(NotFound::new);
    }
}
