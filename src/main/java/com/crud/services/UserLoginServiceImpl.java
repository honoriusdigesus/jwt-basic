package com.crud.services;

import com.crud.entity.UserLogin;
import com.crud.repository.UserLoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserLoginServiceImpl implements UserLoginService{
    private UserLoginRepository userLoginRepository;
    HashMap<String, Object> dates;


    @Override
    public Optional<UserLogin> findUserByDi(BigDecimal di) {
        Optional<UserLogin> userLogin = userLoginRepository.findUserByDi(di);
        dates = new HashMap<>();
        if (userLogin.isPresent()) {
            dates.put("SEARCH", "User found");
            return userLogin;
        }
        dates.put("SEARCH", "User no found");
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Object> save(UserLogin user) {
        Optional<UserLogin> userLogin = userLoginRepository.findUserByDi(user.getDi());
        dates = new HashMap<>();
        if (userLogin.isPresent()) {
            dates.put("SAVE ERROR", "Error saving, user already exists");
            return new ResponseEntity<>(dates , HttpStatus.CONFLICT);
        }
        userLoginRepository.save(user);
        dates.put("SAVED", "Saved user");
        return new ResponseEntity<>(dates, HttpStatus.CREATED);
    }
}
