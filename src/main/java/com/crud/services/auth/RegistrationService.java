package com.crud.services.auth;

import com.crud.dto.UserLoginDTO;
import com.crud.entity.UserLogin;
import com.crud.entity.auth.ConfirmationToken;
import com.crud.exception.EmailAlreadyTaken;
import com.crud.services.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserLoginService userLoginService;
    private ConfirmationTokenService confirmationTokenService;

    public String register(UserLoginDTO userLoginDTO) {
        boolean existEmail = userLoginService.existByEmail(userLoginDTO.getEmail());
        if (existEmail) {
            throw new EmailAlreadyTaken(userLoginDTO.getEmail());
        }
        //TODO: Encrypt password
        UserLogin user = new UserLogin();
        user.setDi(userLoginDTO.getDi());
        user.setName(userLoginDTO.getName());
        user.setLastname(userLoginDTO.getLastname());
        user.setEmail(userLoginDTO.getEmail());
        user.setPassword(userLoginDTO.getPassword());
        user.setRol(userLoginDTO.getRol());
        user.setActive(userLoginDTO.getActive());
        UserLogin userSaved = userLoginService.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now().plusMinutes(15), userSaved);
        confirmationTokenService.save(confirmationToken);
        return "User registered successfully with ID: " + userSaved.getId();
    }
}
