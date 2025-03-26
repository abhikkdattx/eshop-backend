package com.theabhikdatta.eshop.backend.controller;

import com.theabhikdatta.eshop.backend.entity.Role;
import com.theabhikdatta.eshop.backend.payload.LoginDto;
import com.theabhikdatta.eshop.backend.payload.RegisterDto;
import com.theabhikdatta.eshop.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto){
        var data = authService.login(loginDto);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto registerDto){
        var data = authService.register(registerDto);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/role")
    public ResponseEntity<String> createRole(@RequestBody Role role){
        var data = authService.createRole(role);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles(){
        var data = authService.getAllRoles();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<String> getRoleByName(@PathVariable("name") String name){
        var data = authService.getRoleByName(name);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/role/{name}")
    public ResponseEntity<String> deleteRole(@PathVariable("name") String name){
        var data = authService.deleteRole(name);
        return ResponseEntity.ok(data);
    }
}
