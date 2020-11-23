package com.example.bot.repository;

import com.example.bot.model.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    // Empty.

}
