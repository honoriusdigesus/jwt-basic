package com.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigInteger;

@Data
public class UserLoginDTO {
    private Integer id;
    private BigInteger di;
    private String name;
    private String lastname;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Solo de escritura, así no se retorna la contraseña
    private String password;
    private String rol = "USER";
    private Boolean active = false;
}
