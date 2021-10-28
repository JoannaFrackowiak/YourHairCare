package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.Silicon;
import com.homeproject.yourhaircare.service.dto.SiliconDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SiliconMapper {

    public SiliconDto toDto(Silicon silicon) {
        List<Long> cosmeticsWithSilicon = silicon.getCosmeticsWithSilicon()
                .stream()
                .map(siliconCosmetic -> siliconCosmetic.getId())
                .collect(Collectors.toList());

        return SiliconDto.builder()
                .id(silicon.getId())
                .name(silicon.getName())
                .detail(silicon.getDetail())
                .addedAt(silicon.getAddedAt())
                .updatedAt(silicon.getUpdatedAt())
                .cosmeticsWithSilicon(cosmeticsWithSilicon)
                .build();
    }
}
