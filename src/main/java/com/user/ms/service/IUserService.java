package com.user.ms.service;

import com.user.ms.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    ResponseEntity<UserDTO> createUser(UserDTO userDTO);
    ResponseEntity<List<UserDTO>> getAllUsers();
    ResponseEntity<UserDTO> getUserById(String id);
    ResponseEntity<UserDTO> updateUser(String id, UserDTO userDTO);
    ResponseEntity<String> deleteUser(String id);
}
