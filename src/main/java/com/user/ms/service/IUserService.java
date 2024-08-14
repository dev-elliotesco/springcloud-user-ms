package com.user.ms.service;

import com.user.ms.dto.UserDTO;
import com.user.ms.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    ResponseEntity<UserEntity> createUser(UserDTO userDTO);
    ResponseEntity<List<UserEntity>> getAllUsers();
    ResponseEntity<UserEntity> getUserById(String id);
    ResponseEntity<UserEntity> updateUser(String id, UserDTO userDTO);
    ResponseEntity<String> deleteUser(String id);
}
