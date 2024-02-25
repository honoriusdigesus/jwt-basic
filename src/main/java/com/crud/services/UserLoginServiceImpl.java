package com.crud.services;

import com.crud.dto.UserLoginDTO;
import com.crud.entity.UserLogin;
import com.crud.mapper.UserLoginMapper;
import com.crud.repository.UserLoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserLoginServiceImpl implements UserLoginService{

    private UserLoginRepository userLoginRepository;
    private UserLoginMapper userLoginMapper;
    HashMap<String, Object> dates;

    @Override
    public ResponseEntity<Object> findUserByDi(BigInteger di) {
        Optional<UserLogin> userLogin = userLoginRepository.findUserByDi(di);
        dates = new HashMap<>();
        if (userLogin.isPresent()) {
            dates.put("SEARCH", "User found");
            return new ResponseEntity<>(userLoginMapper.convertToUserDTO(userLogin), HttpStatus.OK);
        }
        dates.put("SEARCH", "User no found");
        return new ResponseEntity<>(dates , HttpStatus.NOT_FOUND);
    }

    @Override
    public UserLogin save(UserLogin user) {
        return userLoginRepository.save(user);
    }

    @Override
    public ResponseEntity<Object> updateUser(UserLogin user) {
        Optional<UserLogin> userResult = userLoginRepository.findUserByDi(user.getDi());
        dates = new HashMap<>();
        if (userResult.isPresent()) {
            userLoginRepository.save(user);
            dates.put("UPDATE", "User successfully updated");
            return new ResponseEntity<>(dates , HttpStatus.CREATED);
        }
        dates.put("UPDATE ERROR", "The user could not be updated successfully");
        return new ResponseEntity<>(dates, HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<Object> delete(BigInteger di) {
        Optional<UserLogin> userLogin = userLoginRepository.findUserByDi(di);
        dates = new HashMap<>();
        if (userLogin.isPresent()) {
            userLoginRepository.deleteById(userLogin.get().getId());
            dates.put("DELETE", "User successfully deleted");
            return new ResponseEntity<>(dates, HttpStatus.ACCEPTED);
        }
        dates.put("DELETE", "The user is not registered");
        return new ResponseEntity<>(dates , HttpStatus.NOT_FOUND);
    }

    @Override
    public boolean existByEmail(String email) {
        return userLoginRepository.existsByEmail(email);
    }

}
