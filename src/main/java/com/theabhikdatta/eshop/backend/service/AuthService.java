package com.theabhikdatta.eshop.backend.service;

import com.theabhikdatta.eshop.backend.entity.Role;
import com.theabhikdatta.eshop.backend.payload.LoginDto;
import com.theabhikdatta.eshop.backend.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(Role role);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);
}