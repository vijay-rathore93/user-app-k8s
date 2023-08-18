package com.vijaycode.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "user_login_details")
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_login_seq")
    @SequenceGenerator(name = "user_login_seq", sequenceName = "user_login_seq", initialValue = 6000)
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
