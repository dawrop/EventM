package com.example.backend.controllers;

import com.example.backend.payload.request.AvatarChangeRequest;
import com.example.backend.payload.request.PasswordChangeRequest;
import com.example.backend.payload.response.UserResponse;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/me")
    public UserResponse me(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.getUser(userDetails.getUsername());
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody @Valid PasswordChangeRequest passwordChangeRequest) {
        return userService.changePassword(userDetails.getEmail(), passwordChangeRequest);
    }

    @PutMapping("/changeAvatar")
    public ResponseEntity<?> changeAvatar(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody @Valid AvatarChangeRequest avatarChangeRequest) {
        return userService.changeAvatar(userDetails.getEmail(), avatarChangeRequest);
    }
}
