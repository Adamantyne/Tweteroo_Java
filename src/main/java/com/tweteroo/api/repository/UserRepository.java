package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}
