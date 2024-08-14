package com.user.ms.service.impl;

import com.user.ms.model.UserEntity;
import com.user.ms.repository.IUserRepository;
import com.user.ms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    @Override
    public ResponseEntity<UserEntity> createUser(UserEntity userEntity) {
        try{
            UserEntity newUser = this.iUserRepository.save(userEntity);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(newUser);
        }catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = iUserRepository.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @Override
    public ResponseEntity<UserEntity> getUserById(String id) {
        Optional<UserEntity> user = iUserRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(String id, UserEntity userEntity) {
        Optional<UserEntity> existingUser = iUserRepository.findById(id);
        if (existingUser.isPresent()) {
            UserEntity updatedUser = existingUser.get();
            updatedUser.setTypeDocument(userEntity.getTypeDocument());
            updatedUser.setDocument(userEntity.getDocument());
            updatedUser.setName(userEntity.getName());
            iUserRepository.save(updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        if (iUserRepository.existsById(id)) {
            iUserRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
