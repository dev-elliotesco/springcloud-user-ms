package com.user.ms.service.impl;

import com.user.ms.model.UserEntity;
import com.user.ms.repository.IUserRepository;
import com.user.ms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
