package com.example.bot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TelegramUser {

    @Id
    private final Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Answer> answers;

    // Default contructor required by Servlet.
    public TelegramUser() {
        id = null;
    }

    public TelegramUser(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
}
