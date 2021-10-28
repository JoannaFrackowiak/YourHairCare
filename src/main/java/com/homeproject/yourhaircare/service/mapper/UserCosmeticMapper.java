package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.UserCosmetic;
import com.homeproject.yourhaircare.service.dto.UserCosmeticDto;
import org.springframework.stereotype.Component;

@Component
public class UserCosmeticMapper {


    public UserCosmeticDto toDto(UserCosmetic userCosmetic) {
        Long userId = null;
        if (userCosmetic.getUserCosmetic() != null) {
            userId = userCosmetic.getUserCosmetic().getId();
        }
        Long cosmeticId = null;
        if (userCosmetic.getCosmeticUser() != null) {
            cosmeticId = userCosmetic.getCosmeticUser().getId();
        }
        return UserCosmeticDto.builder()
                .id(userCosmetic.getId())
                .userCosmeticId(userId)
                .cosmeticUserId(cosmeticId)
                .createdAt(userCosmetic.getCreatedAt())
                .updatedAt(userCosmetic.getUpdatedAt())
                .build();
    }

//    public UserCosmetic fromDto() {
//    }
}


