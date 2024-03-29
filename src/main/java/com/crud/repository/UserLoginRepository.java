package com.crud.repository;

import com.crud.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
    Optional<UserLogin> findUserByDi(BigInteger di);
    boolean existsByEmail(String email);
}
