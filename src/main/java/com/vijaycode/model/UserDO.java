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
public class UserDO {
    private int userId;
    @NotNull(message = "Name can not be null")
    @NotEmpty(message = "Name can not be empty")
    private String fullName;
    private int age;
    private long contact;
    private UserLoginDetailDO userLoginDetail;
}
