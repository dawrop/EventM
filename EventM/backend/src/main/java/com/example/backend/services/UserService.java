package com.example.backend.services;

import com.example.backend.models.User;
import com.example.backend.payload.request.AvatarChangeRequest;
import com.example.backend.payload.request.PasswordChangeRequest;
import com.example.backend.payload.response.MessageResponse;
import com.example.backend.payload.response.UserResponse;
import com.example.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public UserResponse getUser(String email) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .build();
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .avatar(user.getAvatar())
                        .build())
                .collect(Collectors.toList());
    }

    public ResponseEntity<?> changePassword(String email, PasswordChangeRequest passwordChangeRequest) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordChangeRequest.getNewPassword().equals(passwordChangeRequest.getRepeatNewPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Passwords don't match!"));
        }

        if (!encoder.matches(passwordChangeRequest.getOldPassword(), user.getPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Incorrect old password!"));
        }

        user.setPassword(encoder.encode(passwordChangeRequest.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Password successfully changed!"));
    }

    public ResponseEntity<?> changeAvatar(String email, AvatarChangeRequest avatarChangeRequest) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setAvatar(avatarChangeRequest.getAvatarUuid());
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Avatar successfully changed!"));
    }
}
