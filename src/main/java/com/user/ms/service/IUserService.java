package com.user.ms.service;

import com.user.ms.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    ResponseEntity<UserEntity> createUser(UserEntity userEntity);
    ResponseEntity<List<UserEntity>> getAllUsers();
    ResponseEntity<UserEntity> getUserById(String id);
    ResponseEntity<UserEntity> updateUser(String id, UserEntity userEntity);
    ResponseEntity<String> deleteUser(String id);
}
