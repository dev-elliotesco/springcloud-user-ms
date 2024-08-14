package com.user.ms.repository;

import com.user.ms.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByDocumentAndTypeDocument (String document, String typeDocument);
}
