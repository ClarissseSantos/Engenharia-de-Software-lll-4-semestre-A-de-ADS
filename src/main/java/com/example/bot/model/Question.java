package com.example.bot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id = null;

    @Column(unique = true)
    @NotNull
    private String question;

    @NotNull
    private String answer;

    @NotNull
    private String wrongAnswer1;

    @NotNull
    private String wrongAnswer2;

    @NotNull
    private String wrongAnswer3;

    // Default contructor required by Servlet.
    public Question() {
        // Empty.
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer3;
    }

    public void setWrongAnswer1(final String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public String getWrongAnswer2() {
        return wrongAnswer3;
    }

    public void setWrongAnswer2(final String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(final String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

}
