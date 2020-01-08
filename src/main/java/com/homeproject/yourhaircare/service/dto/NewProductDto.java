package com.homeproject.yourhaircare.service.dto;

import com.homeproject.yourhaircare.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NewProductDto {

    private Long id;
    private Long userAddProductId;
    private String brand;
    private String type;
    private String feature;
    private String name;
    private Boolean silicon;
    private Boolean preservative;
    private String additionalInfo;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
}
