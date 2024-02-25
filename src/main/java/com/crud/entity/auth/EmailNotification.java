package com.crud.entity.auth;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class EmailNotification {
    private String to;
    private String subject;
    private String body;
    private boolean hasTemplate;
}
