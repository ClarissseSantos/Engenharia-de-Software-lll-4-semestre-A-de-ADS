package com.example.bot.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.bot.service.TelegramUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private TelegramUserService telegramUserService;

    private InlineKeyboardMarkup getInlineKeyboardMarkup() {
        final List<InlineKeyboardButton> keyboard = new ArrayList<InlineKeyboardButton>(4);

        keyboard.add(new InlineKeyboardButton().setText("Again").setCallbackData("0"));
        keyboard.add(new InlineKeyboardButton().setText("Hard").setCallbackData("1"));
        keyboard.add(new InlineKeyboardButton().setText("Good").setCallbackData("2"));
        keyboard.add(new InlineKeyboardButton().setText("Easy").setCallbackData("3"));

        final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup()
            .setKeyboard(Collections.singletonList(keyboard));

        inlineKeyboardMarkup.setKeyboard(Collections.singletonList(keyboard));

        return inlineKeyboardMarkup;
    }

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            final Integer id = update.getMessage().getFrom().getId();

            final String text;

            if(telegramUserService.seen(id)) {
                text = "I have seen you before.";
            } else {
                text = "I have never seen you before.";
            }

            telegramUserService.save(id);

            final SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(text)
                    .setReplyMarkup(getInlineKeyboardMarkup());

            try {
                execute(message);
            } catch (final TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "EristicBot";
    }

    @Override
    public String getBotToken() {
        return "1402811436:AAF7uT_xC-4OJNK2QiYJbUAbRzhquC9vKqY";
    }

}
