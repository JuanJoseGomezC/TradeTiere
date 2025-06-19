package com.back.tradetier.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDto {
    String mail;
    String name;
    String lastname;
    LocalDate birthdate;
    String password;
}
