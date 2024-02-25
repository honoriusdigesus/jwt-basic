package com.crud.services;

import com.crud.entity.UserLogin;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface UserLoginService {
    ResponseEntity<Object> findUserByDi(BigInteger di);
    UserLogin save (UserLogin user);
    ResponseEntity<Object> updateUser (UserLogin user);
    ResponseEntity<Object> delete(BigInteger di);

    boolean existByEmail(String email);

}
