package com.user.ms.controller;

import com.user.ms.model.UserEntity;
import com.user.ms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }
}
