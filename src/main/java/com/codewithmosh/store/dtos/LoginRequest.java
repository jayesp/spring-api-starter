package com.codewithmosh.store.dtos;

import com.codewithmosh.store.validation.Lowercase;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email cannot be null.")
    @Email(message = "Email is invalid.")
    @Lowercase(message = "Email must be in lowercase")
    private String email;

    @NotBlank(message = "Password cannot be null.")
    @Size(min = 6, max = 25, message = "Password must be at least 6 to 25 characters")
    private String password;
}
