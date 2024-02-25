package com.crud.services.auth;

import com.crud.entity.auth.EmailNotification;

public interface EmailService {
    void sendEmail(EmailNotification emailNotification);
}
