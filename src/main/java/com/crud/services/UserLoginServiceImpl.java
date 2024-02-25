package com.crud.services;

import com.crud.dto.UserLoginDTO;
import com.crud.entity.UserLogin;
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
    HashMap<String, Object> dates;


    @Override
    public ResponseEntity<Object> findUserByDi(BigInteger di) {
        Optional<UserLogin> userLogin = userLoginRepository.findUserByDi(di);
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        dates = new HashMap<>();
        if (userLogin.isPresent()) {
            dates.put("SEARCH", "User found");

            userLoginDTO.setId(userLogin.get().getId());
            userLoginDTO.setDi(userLogin.get().getDi());
            userLoginDTO.setName(userLogin.get().getName());
            userLoginDTO.setLastname(userLogin.get().getLastname());
            userLoginDTO.setEmail(userLogin.get().getEmail());
            userLoginDTO.setPassword(userLogin.get().getPassword());
            userLoginDTO.setRol(userLogin.get().getRol());
            userLoginDTO.setActive(userLogin.get().getActive());

            return new ResponseEntity<>(userLoginDTO, HttpStatus.OK);
        }
        dates.put("SEARCH", "User no found");
        return new ResponseEntity<>(dates , HttpStatus.NOT_FOUND);
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
            //return userLogin;
            return new ResponseEntity<>(dates, HttpStatus.ACCEPTED);
        }
        dates.put("DELETE", "The user is not registered");
        return new ResponseEntity<>(dates , HttpStatus.NOT_FOUND);
    }

}
