package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCosmeticDto {

    private Long id;
    private Long userCosmeticId;
    private Long cosmeticUserId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
