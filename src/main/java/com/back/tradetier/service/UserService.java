package com.back.tradetier.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.tradetier.config.security.JwtService;
import com.back.tradetier.controller.UserController;
import com.back.tradetier.dto.LoginDto;
import com.back.tradetier.dto.RegisterDto;
import com.back.tradetier.dto.TokenDto;
import com.back.tradetier.dto.UpdateUserDto;
import com.back.tradetier.dto.UserDto;
import com.back.tradetier.exceptions.UserExistException;
import com.back.tradetier.exceptions.UserLoginException;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtService jwtService;



    public List<UserDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public UserDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public UserController createUser(UserDto user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    public UpdateUserDto updateUser(Integer id, UpdateUserDto user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    public void deleteUser(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Transactional
    public TokenDto login(LoginDto loginDto) {
    User user = userRepository.findByMail(loginDto.getMail())
            .orElseThrow(UserLoginException::new);

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UserLoginException();
        }
        String token = jwtService.generateToken(user);

        return new TokenDto(token);
    }

    @Transactional
    public TokenDto register(RegisterDto registerDto) {
        userRepository.findByMail(registerDto.getMail()).ifPresent( user -> {throw new UserExistException();});

        User user = toUser(registerDto, passwordEncoder);

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return TokenDto.builder()
                .token(jwtToken)
                .build();
    }

    public static User toUser(RegisterDto dto, PasswordEncoder passwordEncoder) {
        return User.builder()
                .mail(dto.getMail())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .birthdate(dto.getBirthdate())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
    }




}
