package com.user.ms.service.impl;

import com.user.ms.dto.UserDTO;
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
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    @Override
    public ResponseEntity<UserEntity> createUser(UserDTO userDTO) {
        UserEntity userEntity = toEntity(userDTO);
        try{
            UserEntity newUser = this.iUserRepository.save(userEntity);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userEntity);
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
    public ResponseEntity<UserEntity> updateUser(String id, UserDTO userDTO) {
        UserEntity user = iUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(MessageUtils.USER_NOT_FOUND + id));

        user.setTypeDocument(userDTO.getTypeDocument());
        user.setDocument(userDTO.getDocument());
        user.setName(userDTO.getName());

        UserEntity updatedUser = iUserRepository.save(user);
        return ResponseEntity.ok(updatedUser);
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

    private UserDTO toDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .typeDocument(userEntity.getTypeDocument())
                .document(userEntity.getDocument())
                .name(userEntity.getName())
                .build();
    }

    private UserEntity toEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .typeDocument(userDTO.getTypeDocument())
                .document(userDTO.getDocument())
                .name(userDTO.getName())
                .build();
    }
}
