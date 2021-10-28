package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.Cosmetic;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateAndChangeCosmeticDto;
import com.homeproject.yourhaircare.service.dto.CosmeticToShowDto;
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
                .name(createCosmeticDto.getName())
                .build();
    }

    public CosmeticToShowDto toDtoTest(Cosmetic cosmetic) {
//        Long brandId = null;
//        if(cosmetic.getBrand() != null) {
//            brandId = cosmetic.getBrand().getId();
//        }
        String brandName = null;
        if(cosmetic.getBrand() != null) {
            brandName = cosmetic.getBrand().getName();
        }

        String typeName = null;
        if(cosmetic.getType() != null) {
            typeName = cosmetic.getType().getName();
        }

        String featureName = null;
        if(cosmetic.getFeature() != null) {
            featureName = cosmetic.getFeature().getName();
        }

        List<String> siliconsNamesInCosmeticId = cosmetic.getSiliconsInCosmetic()
                .stream()
                .map(siliconCosmetic -> siliconCosmetic.getSilicon().getName())
                .collect(Collectors.toList());

        List<Long> assignedUsersId = cosmetic.getAssignedUsers()
                .stream()
                .map(user -> user.getId())
                .collect(Collectors.toList());

        List<Long> assignedShoppingListsId = cosmetic.getAssignedShoppingLists()
                .stream()
                .map(shoppingList -> shoppingList.getId())
                .collect(Collectors.toList());

        return CosmeticToShowDto.builder()
                .id(cosmetic.getId())
                .brandName(brandName)
                .typeName(typeName)
                .featureName(featureName)
                .name(cosmetic.getName())
                .preservative(cosmetic.getPreservative())
                .addedAt(cosmetic.getAddedAt())
                .updatedAt(cosmetic.getUpdatedAt())
                .siliconsNamesInCosmetic(siliconsNamesInCosmeticId)
                .assignedUsersId(assignedUsersId)
                .assignedShoppingListsId(assignedShoppingListsId)
                .build();
    }

}


