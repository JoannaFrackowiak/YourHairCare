package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateUpdateUserCosmeticDto {

    private Long userCosmeticId;
    private Long cosmeticUserId;
}
