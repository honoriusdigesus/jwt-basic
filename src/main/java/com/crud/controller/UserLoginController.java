package com.crud.controller;

import com.crud.entity.UserLogin;
import com.crud.services.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserLoginController {
    private UserLoginService userLoginService;

    @GetMapping("/{di}")
    public ResponseEntity<Object> findUserByDi(@PathVariable BigInteger di) {
        return ResponseEntity.ok(userLoginService.findUserByDi(di));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserLogin userLogin) {
        return ResponseEntity.ok(userLoginService.save(userLogin));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UserLogin userLogin) {
        return ResponseEntity.ok(userLoginService.updateUser(userLogin));
    }

    @DeleteMapping("/{di}")
    public ResponseEntity<Object> delete(@PathVariable BigInteger di) {
        return ResponseEntity.ok(userLoginService.delete(di));
    }
}
