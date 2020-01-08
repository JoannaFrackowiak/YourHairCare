package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CosmeticDto {

    private Long id;
    private Long brandId;
    private Long typeId;
    private Long featureId;
    private String name;
    private Boolean preservative;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
    private List<Long> siliconsInCosmeticId;
    private List<Long> assignedUsersId;
    private List<Long> assignedShoppingListsId;
}
