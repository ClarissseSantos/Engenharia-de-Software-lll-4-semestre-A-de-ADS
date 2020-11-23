package com.example.bot.service;

import com.example.bot.model.TelegramUser;
import com.example.bot.repository.TelegramUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserService {

    @Autowired
    private TelegramUserRepository telegramUserRepository;

    public Boolean seen(final Integer id) {
        return telegramUserRepository.findById(id).isPresent();
    }

    public TelegramUser save(final Integer id) {
        return telegramUserRepository.save(new TelegramUser(id));
    }

}
