package com.crud.controller.auth;

import com.crud.dto.UserLoginDTO;
import com.crud.entity.auth.EmailNotification;
import com.crud.services.auth.EmailService;
import com.crud.services.auth.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private RegistrationService registrationService;
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserLoginDTO userLoginDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.register(userLoginDTO));
    }

    @PostMapping("/sendmail")
    public String sendEmail(){
        EmailNotification email = EmailNotification.builder()
                .to("honoriodigesus@gmail.com")
                .subject("Text")
                .body("Texto plano")
                .hasTemplate(false)
                .build();

        EmailNotification email2 = EmailNotification.builder()
                .to("honoriodigesus@gmail.com")
                .subject("Text")
                .body("<h1> Template </h1>")
                .hasTemplate(false)
                .build();

        emailService.sendEmail(email);
        emailService.sendEmail(email2);

        return "Correo enviado exitosamente";
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam String token){
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.confirm(token));
    }
}
