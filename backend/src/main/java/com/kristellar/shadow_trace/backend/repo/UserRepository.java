package com.kristellar.shadow_trace.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kristellar.shadow_trace.backend.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUsername(String username);
}
