package com.user.ms.service;

import com.user.ms.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<UserEntity> createUser(UserEntity userEntity);
}
