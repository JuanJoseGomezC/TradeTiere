package com.back.tradetier.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UserDto {
    Integer id;
    Date birthday;
    String mail;
    String name;
    String lastname;
    Date createAt;
    @JsonProperty(access= Access.WRITE_ONLY)
    String password;
}
