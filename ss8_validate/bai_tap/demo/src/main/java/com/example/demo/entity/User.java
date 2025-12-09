package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    @NotBlank(message = "Username cannot null")
    private String username;
    @NotBlank(message = "Email cannot null")
    @Email(message = "Email not valid")
    private String email;
    @NotBlank(message = "Password cannot null")
    private String password;
}
