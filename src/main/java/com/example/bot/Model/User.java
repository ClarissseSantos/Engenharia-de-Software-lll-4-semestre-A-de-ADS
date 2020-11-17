package com.example.bot.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id = null;

    @OneToMany(mappedBy = "author")
    private List<Answer> answers;

    // Default contructor required by Servlet.
    public User() {
        // Empty.
    }
    
}
