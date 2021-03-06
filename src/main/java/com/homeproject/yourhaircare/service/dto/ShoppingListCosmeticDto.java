package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListCosmeticDto {

    private Long id;
    private Long shoppingListId;
    private Long cosmeticFromShopId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
