package com.crud.services;

import com.crud.entity.UserLogin;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface UserLoginService {
    ResponseEntity<Object> findUserByDi(BigDecimal di);
    ResponseEntity<Object> save (UserLogin user);
    ResponseEntity<Object> updateUser (UserLogin user);
    ResponseEntity<Object> delete(BigDecimal di);
}
