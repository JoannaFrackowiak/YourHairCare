package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SiliconDto {

    private Long id;
    private String name;
    private String detail;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
    private List<Long> cosmeticsWithSilicon; //SiliconCosmetic
}
