package com.crud.services.auth;

import com.crud.entity.auth.ConfirmationToken;

public interface ConfirmationTokenService {
    void save(ConfirmationToken confirmationToken);
}
