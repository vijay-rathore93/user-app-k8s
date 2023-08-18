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
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 5000)
    private int userId;
    @NotNull(message = "Name can not be null")
    @NotEmpty(message = "Name can not be empty")
    private String fullName;
    private int age;
    private long contact;


    @JoinColumn(name = "user_user_login_details_id")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private UserLoginDetail userLoginDetail;


}
