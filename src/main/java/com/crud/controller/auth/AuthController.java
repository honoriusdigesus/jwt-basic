package com.crud.controller.auth;

import com.crud.dto.UserLoginDTO;
import com.crud.services.auth.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserLoginDTO userLoginDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.register(userLoginDTO));
    }
}
