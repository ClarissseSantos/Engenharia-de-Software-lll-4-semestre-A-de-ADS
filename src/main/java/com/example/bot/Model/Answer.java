package com.example.bot.Model;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
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

    @Column(name = "user")
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

    public void update(final int answer) {
        final Date today = new Date();

        int diff = (int) Duration.between(today.toInstant(), getNext().toInstant()).toDays();

        final Calendar calendar = Calendar.getInstance();

        diff = diff * (int) Math.round(getEase());

        switch (answer) {
            case 0:
                diff = 0;
                setEase(1.0);
                break;
            case 1:
                setEase(0.75 * getEase());
                break;
            case 2:
                setEase(1.00 * getEase());
                break;
            case 3:
                setEase(1.25 * getEase());
                break;
            default:
                throw new IndexOutOfBoundsException("Answer " + answer + " is out of bounds!");
        }
        
        calendar.setTime(today);
        calendar.add(Calendar.DATE, diff);
        
        setNext(calendar.getTime());
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
