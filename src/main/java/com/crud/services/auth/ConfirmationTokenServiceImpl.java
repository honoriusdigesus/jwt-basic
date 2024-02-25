package com.crud.services.auth;

import com.crud.entity.auth.ConfirmationToken;
import com.crud.repository.auth.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Override
    public void save(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }
}
