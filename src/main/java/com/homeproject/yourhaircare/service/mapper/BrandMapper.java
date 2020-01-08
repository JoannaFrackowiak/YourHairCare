package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.Brand;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrandMapper {

    public BrandDto toDto(Brand brand) {
        List<Long> cosmeticsIdList = brand.getCosmeticsList()
                .stream()
                .map(cosmetic -> cosmetic.getId())
                .collect(Collectors.toList());

        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .addedAt(brand.getAddedAt())
                .updatedAt(brand.getUpdatedAt())
                .cosmeticsIdList(cosmeticsIdList)
                .build();
    }
}
