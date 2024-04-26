package com.example.felipe.sec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.felipe.sec.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(String username);
}
