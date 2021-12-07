package com.example.backend.payload.response;

import com.example.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String avatar;

//    public UserResponse(User user) {
//        id = user.getId();
//        name = user.getName();
//        email = user.getEmail();
//        avatar = user.getAvatar();
//    }
}
