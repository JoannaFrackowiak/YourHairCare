package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeatureDto {

    private Long id;
    private String name;
    private String description;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
    private List<Long> cosmeticsIdList;

}
