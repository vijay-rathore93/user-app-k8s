package com.vijaycode.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDetailDO {
    private int id;
    @NotNull(message = "Username can not null")
    @NotEmpty(message = "Username can not empty")
    private String username;
    @NotNull(message = "Password can not be null")
    @NotEmpty(message = "Password cn not be empty")
    private String password;
    @NotNull(message = "Email can not be null")
    @NotEmpty(message = "Email can not be empty")
    private String email;
}
