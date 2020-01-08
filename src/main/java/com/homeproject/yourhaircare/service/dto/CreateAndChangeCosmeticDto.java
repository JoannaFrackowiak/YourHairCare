package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateAndChangeCosmeticDto {

    private Long brandId;
    private Long typeId;
    private Long featureId;
    private String name;
    private Boolean preservative;
}
