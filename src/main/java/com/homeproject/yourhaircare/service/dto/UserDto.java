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
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private List<Long> cosmeticsOfUser; //UserCosmetic
}
