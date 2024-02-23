package com.crud.services;

import com.crud.entity.UserLogin;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserLoginService {
    Optional<UserLogin> findUserByDi(BigDecimal di);
    ResponseEntity<Object> save (UserLogin user);
}
