package com.example.bot.repository;

import com.example.bot.Model.TelegramUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Integer> {

    // Empty.
    
}
