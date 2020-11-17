package com.example.bot.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id = null;

    @NotNull
    private User user;

    @NotNull
    private Date next;

    @NotNull
    private Double ease;

    // Default contructor required by Servlet.
    public Answer() {
        // Empty.
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Date getNext() {
        return next;
    }

    public void setNext(final Date next) {
        this.next = next;
    }

    public Double getEase() {
        return ease;
    }

    public void setEase(final Double ease) {
        this.ease = ease;
    }
    
}
