package com.crud.mapper;

import com.crud.dto.UserLoginDTO;
import com.crud.entity.UserLogin;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserLoginMapper {
    public UserLoginDTO convertToUserDTO(Optional<UserLogin> userLogin) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setId(userLogin.get().getId());
        userLoginDTO.setDi(userLogin.get().getDi());
        userLoginDTO.setName(userLogin.get().getName());
        userLoginDTO.setLastname(userLogin.get().getLastname());
        userLoginDTO.setEmail(userLogin.get().getEmail());
        userLoginDTO.setPassword(userLogin.get().getPassword());
        userLoginDTO.setRol(userLogin.get().getRol());
        userLoginDTO.setActive(userLogin.get().getActive());
        return userLoginDTO;
    }
}
