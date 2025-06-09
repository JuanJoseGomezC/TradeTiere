package com.back.tradetier.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.UpdateUserDto;
import com.back.tradetier.dto.UserDto;
import com.back.tradetier.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll() {
        log.info("Request to get all users");
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        log.info("Request to get user by id: {}", id);
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<UpdateUserDto> updateCurrentUser(@Valid @RequestBody UpdateUserDto user) {
        log.info("Request to update current user profile");
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/deleteUser/{mail}")
    public ResponseEntity<Void> deleteUser(@PathVariable String mail) {
        log.info("Request to delete user with id: {}", mail);
        userService.deleteUser(mail);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getByMail/{mail}")
    public ResponseEntity<UserDto> getByMail(@PathVariable String mail) {
        log.info("Request to get user by mail: {}", mail);
        return ResponseEntity.ok(userService.getByMail(mail));
    }
}