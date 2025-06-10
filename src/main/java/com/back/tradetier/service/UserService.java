package com.back.tradetier.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.tradetier.config.security.JwtService;
import com.back.tradetier.config.security.SecurityUtils;
import com.back.tradetier.dto.LoginDto;
import com.back.tradetier.dto.RegisterDto;
import com.back.tradetier.dto.TokenDto;
import com.back.tradetier.dto.UpdateUserDto;
import com.back.tradetier.dto.UserDto;
import com.back.tradetier.exceptions.InvalidTokenException;
import com.back.tradetier.exceptions.ResourceNotFoundException;
import com.back.tradetier.exceptions.UnauthorizedAccessException;
import com.back.tradetier.exceptions.UserExistException;
import com.back.tradetier.exceptions.UserLoginException;
import com.back.tradetier.exceptions.UserMailException;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service for managing users.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final SecurityUtils securityUtils;

    /**
     * Get all users.
     *
     * @return list of all users as DTOs
     */
    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        log.info("Getting all users");
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    /**
     * Get a user by ID.
     *
     * @param id the user ID
     * @return the user DTO
     * @throws ResourceNotFoundException if the user is not found
     */
    @Transactional(readOnly = true)
    public UserDto getById(Integer id) {
        log.info("Getting user by id: {}", id);
        return userRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    /**
     * Update the current user based on the JWT token.
     *
     * @param updateDto the update data
     * @return the updated user DTO
     * @throws ResourceNotFoundException if the user is not found
     * @throws InvalidTokenException     if the token is invalid
     */
    @Transactional
    public UpdateUserDto updateUser(UpdateUserDto updateDto) {
        // Get email from security context (JWT token)
        String mail = securityUtils.getCurrentUser().getMail();
        log.info("Updating user with email: {}", mail);

        User user = userRepository.findByMail(mail)
                .orElseThrow(UserMailException::new);

        // Validate update fields
        validateRegisterFields(updateDto);

        // Update only non-null fields
        if (updateDto.getName() != null) {
            user.setName(updateDto.getName());
        }

        if (updateDto.getLastname() != null) {
            user.setLastname(updateDto.getLastname());
        }

        if (updateDto.getBirthday() != null) {
            user.setBirthdate(updateDto.getBirthday().toLocalDate());
        }

        // si la contraseña esta vacía, no la actualiza
        if (updateDto.getPassword() != null && !updateDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(updateDto.getPassword()));
        }
        userRepository.save(user);
        log.info("User updated successfully");

        return updateDto;
    }

    /**
     * Delete a user.
     *
     * @param id the user ID
     * @throws ResourceNotFoundException if the user is not found
     */
    @Transactional
    public void deleteUser(String mail) {

        if (!securityUtils.getCurrentUser().getMail().equals(mail)) {
            throw new UnauthorizedAccessException("You can only delete your own account");
        }
        log.info("Deleting user with id: {}", mail);

        User user = userRepository.findByMail(mail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + mail));
        userRepository.delete(user);
        log.info("User deleted successfully");
    }

    /**
     * Login a user.
     *
     * @param loginDto the login data
     * @return a token DTO
     * @throws UserLoginException if the login fails
     */
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

    /**
     * Register a new user.
     *
     * @param registerDto the registration data
     * @return a token DTO
     * @throws UserExistException if the user already exists
     */
    @Transactional
    public TokenDto register(RegisterDto registerDto) {
        userRepository.findByMail(registerDto.getMail())
                .ifPresent(user -> {
                    throw new UserExistException();
                });

        validateRegisterFields(registerDto);
        log.info("Registering new user: {}", registerDto.getMail());
        User user = toUser(registerDto, passwordEncoder);

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return TokenDto.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Convert RegisterDto to User.
     *
     * @param dto             the registration DTO
     * @param passwordEncoder the password encoder
     * @return the user entity
     */
    public static User toUser(RegisterDto dto, PasswordEncoder passwordEncoder) {
        return User.builder()
                .mail(dto.getMail())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .birthdate(dto.getBirthdate())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
    }

    // Validar campos de registro
    /**
     * Validate registration fields.
     *
     * @param registerDto the registration data
     * @throws InvalidTokenException if validation fails
     */
    public void validateRegisterFields(RegisterDto registerDto) {

        if (!registerDto.getMail().matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidTokenException("Invalid email format");
        }
        if (registerDto.getBirthdate().isAfter(java.time.LocalDate.now().minusYears(18))) {
            throw new InvalidTokenException("You must be at least 18 years old to update your profile");
        }
        if (registerDto.getPassword().length() < 8) {
            throw new InvalidTokenException("Password must be at least 8 characters long");
        }
        if (!registerDto.getPassword().matches(".*[A-Z].*") || !registerDto.getPassword().matches(".*[a-z].*")
                || !registerDto.getPassword().matches(".*\\d.*")) {
            throw new InvalidTokenException(
                    "Password must contain at least one uppercase letter, one lowercase letter, and one digit");
        }
    }

    public void validateRegisterFields(UpdateUserDto updateUserDto) {

        if (updateUserDto.getBirthday().toLocalDate().isAfter(java.time.LocalDate.now().minusYears(18))) {
            throw new InvalidTokenException("You must be at least 18 years old to update your profile");
        }

        if (updateUserDto.getPassword() != null) {
            if (updateUserDto.getPassword().length() < 8) {
                throw new InvalidTokenException("Password must be at least 8 characters long");
            }
            if (!updateUserDto.getPassword().matches(".*[A-Z].*") || !updateUserDto.getPassword().matches(".*[a-z].*")
                    || !updateUserDto.getPassword().matches(".*\\d.*")) {
                throw new InvalidTokenException(
                        "Password must contain at least one uppercase letter, one lowercase letter, and one digit");
            }
        }
    }

    /**
     * Get a user by email.
     *
     * @param mail the email
     * @return the user DTO
     * @throws UserMailException if the user is not found
     */
    @Transactional(readOnly = true)
    public UserDto getByMail(String mail) {
        log.info("Getting user by email: {}", mail);
        return userRepository.findByMail(mail)
                .map(this::toDto)
                .orElseThrow(UserMailException::new);
    }

    /**
     * Convert User to UserDto.
     *
     * @param user the user entity
     * @return the user DTO
     */
    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setMail(user.getMail());
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setBirthday(java.sql.Date.valueOf(user.getBirthdate()));
        dto.setCreateAt(java.sql.Date.valueOf(user.getCreatedAt()));
        return dto;
    }

    public UserDto getCurrentUser() {
        String mail = securityUtils.getCurrentUser().getMail();
        log.info("Getting current user by email: {}", mail);
        return userRepository.findByMail(mail)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Current user not found with email: " + mail));
    }
}
