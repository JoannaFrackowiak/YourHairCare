package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.Brand;
import com.homeproject.yourhaircare.model.Type;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeMapper {

    public TypeDto toDto(Type type) {
        List<Long> cosmeticsIdList = type.getCosmeticsList()
                .stream()
                .map(cosmetic -> cosmetic.getId())
                .collect(Collectors.toList());

        return TypeDto.builder()
                .id(type.getId())
                .name(type.getName())
                .addedAt(type.getAddedAt())
                .updatedAt(type.getUpdatedAt())
                .cosmeticsIdList(cosmeticsIdList)
                .build();
    }
}

