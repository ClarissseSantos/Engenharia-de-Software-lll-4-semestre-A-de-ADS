package com.example.bot.repository;

import com.example.bot.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Empty.
    
}
