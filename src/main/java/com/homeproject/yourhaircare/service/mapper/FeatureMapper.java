package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.Feature;
import com.homeproject.yourhaircare.model.Type;
import com.homeproject.yourhaircare.service.dto.FeatureDto;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeatureMapper {

    public FeatureDto toDto(Feature feature) {
        List<Long> cosmeticsIdList = feature.getCosmeticsList()
                .stream()
                .map(cosmetic -> cosmetic.getId())
                .collect(Collectors.toList());

        return FeatureDto.builder()
                .id(feature.getId())
                .name(feature.getName())
                .description(feature.getDescription())
                .addedAt(feature.getAddedAt())
                .updatedAt(feature.getUpdatedAt())
                .cosmeticsIdList(cosmeticsIdList)
                .build();
    }
}
