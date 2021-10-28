package com.homeproject.yourhaircare.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUpdateUserDto {

    @NotBlank(message = "Twoje imię powinno być dłuższe niż jedna litera.")
    @Size(min=2)
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min=6, message = "Twoje hasło musi być dłuższe niż 6 znaków")
    private String password;
}
