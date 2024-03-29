package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table
@Data
public class UserLogin {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Integer id;
    @Column(unique = true)
    private BigInteger di;
    private String name;
    private String lastname;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Solo de escritura, así no se retorna la contraseña
    private String password;
    private String rol = "USER";
    private Boolean active = false;
}
