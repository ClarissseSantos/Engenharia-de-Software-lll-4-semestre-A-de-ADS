package com.example.bot.repository;

import com.example.bot.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    // Empty.
    
}
