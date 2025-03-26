package com.theabhikdatta.eshop.backend.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String name;

    @NotEmpty(message = "Username is required")
    private String username;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "email is required")
    private String email;

    @NotEmpty(message = "password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotEmpty(message = "Role is required")
    private String role;
}
