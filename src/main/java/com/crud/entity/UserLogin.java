package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table
@Data
@Setter
@Getter
public class UserLogin {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal di;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String rol = "USER";
    private Boolean active = false;
}
