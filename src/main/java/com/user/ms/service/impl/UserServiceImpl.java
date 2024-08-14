package com.user.ms.service.impl;

import com.user.ms.exception.SaveFailedException;
import com.user.ms.exception.UserNotFoundException;
import com.user.ms.model.UserEntity;
import com.user.ms.repository.IUserRepository;
import com.user.ms.service.IUserService;
import com.user.ms.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new SaveFailedException(MessageUtils.SAVE_FAILED + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = iUserRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserEntity> getUserById(String id) {
        UserEntity user = iUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(MessageUtils.USER_NOT_FOUND + id));
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(String id, UserEntity userEntity) {
        UserEntity user = iUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(MessageUtils.USER_NOT_FOUND + id));

        user.setTypeDocument(userEntity.getTypeDocument());
        user.setDocument(userEntity.getDocument());
        user.setName(userEntity.getName());

        iUserRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<String> deleteUser(String id) {
        if (iUserRepository.existsById(id)) {
            iUserRepository.deleteById(id);
            return ResponseEntity.ok(MessageUtils.USER_DELETED_SUCCESSFULLY);
        } else {
            throw new UserNotFoundException(MessageUtils.USER_NOT_FOUND + id);
        }
    }
}
