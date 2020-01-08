package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.Cosmetic;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateAndChangeCosmeticDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CosmeticMapper {

    public CosmeticDto toDto(Cosmetic cosmetic) {
        Long brandId = null;
        if(cosmetic.getBrand() != null) {
            brandId = cosmetic.getBrand().getId();
        }

        Long typeId = null;
        if(cosmetic.getType() != null) {
            typeId = cosmetic.getType().getId();
        }

        Long featureId = null;
        if(cosmetic.getFeature() != null) {
            featureId = cosmetic.getFeature().getId();
        }

        List<Long> siliconsInCosmeticId = cosmetic.getSiliconsInCosmetic()
                .stream()
                .map(siliconCosmetic -> siliconCosmetic.getId())
                .collect(Collectors.toList());

        List<Long> assignedUsersId = cosmetic.getAssignedUsers()
                .stream()
                .map(user -> user.getId())
                .collect(Collectors.toList());

        List<Long> assignedShoppingListsId = cosmetic.getAssignedShoppingLists()
                .stream()
                .map(shoppingList -> shoppingList.getId())
                .collect(Collectors.toList());

        return CosmeticDto.builder()
                .id(cosmetic.getId())
                .brandId(brandId)
                .typeId(typeId)
                .featureId(featureId)
                .name(cosmetic.getName())
                .preservative(cosmetic.getPreservative())
                .addedAt(cosmetic.getAddedAt())
                .updatedAt(cosmetic.getUpdatedAt())
                .siliconsInCosmeticId(siliconsInCosmeticId)
                .assignedUsersId(assignedUsersId)
                .assignedShoppingListsId(assignedShoppingListsId)
                .build();
    }

    public Cosmetic fromDto(CreateAndChangeCosmeticDto createCosmeticDto) {
        return Cosmetic.builder()
                .build();
    }
}
