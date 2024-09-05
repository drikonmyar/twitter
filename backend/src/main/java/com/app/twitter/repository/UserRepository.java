package com.app.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.twitter.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}