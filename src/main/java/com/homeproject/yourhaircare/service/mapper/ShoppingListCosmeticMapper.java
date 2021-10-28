package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.ShoppingListCosmetic;
import com.homeproject.yourhaircare.service.dto.ShoppingListCosmeticDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingListCosmeticMapper {

    public ShoppingListCosmeticDto toDto(ShoppingListCosmetic shoppingListCosmetic) {
        Long shoppingListId = null;
        if (shoppingListCosmetic.getShoppingList() != null) {
            shoppingListId = shoppingListCosmetic.getShoppingList().getId();
        }
        Long cosmeticId = null;
        if (shoppingListCosmetic.getCosmeticFromShop() != null) {
            cosmeticId = shoppingListCosmetic.getCosmeticFromShop().getId();
        }
        return ShoppingListCosmeticDto.builder()
                .id(shoppingListCosmetic.getId())
                .shoppingListId(shoppingListId)
                .cosmeticFromShopId(cosmeticId)
                .createdAt(shoppingListCosmetic.getCreatedAt())
                .updatedAt(shoppingListCosmetic.getUpdatedAt())
                .build();
    }
}
