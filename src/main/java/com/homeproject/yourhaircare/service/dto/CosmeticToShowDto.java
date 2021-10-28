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
public class CosmeticToShowDto {

    private Long id;
    private String brandName;
    private String typeName;
    private String featureName;
    private String name;
    private Boolean preservative;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
    private List<String> siliconsNamesInCosmetic;
    private List<Long> assignedUsersId;
    private List<Long> assignedShoppingListsId;
}
