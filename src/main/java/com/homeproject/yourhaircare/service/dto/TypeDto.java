package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeDto {

    private Long id;
    private String name;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
    private List<Long> cosmeticsIdList;
}
