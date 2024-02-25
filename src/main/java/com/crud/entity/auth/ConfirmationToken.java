package com.crud.entity.auth;

import com.crud.entity.UserLogin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor

public class ConfirmationToken {

    public ConfirmationToken(String token, LocalDateTime expiredAt, UserLogin userLogin) {
        this.token = token;
        this.expiredAt = expiredAt;
        this.userLogin = userLogin;
    }

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime confirmedAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    @ManyToOne
    @JoinColumn(name = "user_login_id")
    private UserLogin userLogin;
}

//Contraseña de la aplicación de google
//Usuario: no.reply.token.jwt@gmail.com
//Password: alzh yely uizf rcop

