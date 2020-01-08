package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateNewProductDto {

    private Long userAddProductId;
    private String brand;
    private String type;
    private String feature;
    private String name;
    private String silicon;
    private String preservative;
    private String additionalInfo;

}
