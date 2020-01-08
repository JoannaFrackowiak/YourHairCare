package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.User;
import com.homeproject.yourhaircare.service.dto.CreateUpdateUserDto;
import com.homeproject.yourhaircare.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        List<Long> cosmeticsOfUser = user.getCosmeticsOfUser()
                .stream()
                .map(userCosmetic -> userCosmetic.getId())
                .collect(Collectors.toList());

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .cosmeticsOfUser(cosmeticsOfUser)
                .build();
    }

    public User fromDto(CreateUpdateUserDto createUpdateUserDto) {
        return User.builder()
                .name(createUpdateUserDto.getName())
                .email(createUpdateUserDto.getEmail())
                .password(createUpdateUserDto.getPassword())
                .createdAt(OffsetDateTime.now())
                .updatedAt(null)
                .build();
    }
}
