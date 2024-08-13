package com.user.ms.repository;

import com.user.ms.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, String> {
}
