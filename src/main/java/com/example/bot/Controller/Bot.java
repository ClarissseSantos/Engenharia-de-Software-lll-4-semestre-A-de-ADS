package com.example.bot.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            final List<InlineKeyboardButton> keyboard = new ArrayList<InlineKeyboardButton>(4);

            keyboard.add(new InlineKeyboardButton().setText("Again").setCallbackData("0"));
            keyboard.add(new InlineKeyboardButton().setText("Hard").setCallbackData("1"));
            keyboard.add(new InlineKeyboardButton().setText("Good").setCallbackData("2"));
            keyboard.add(new InlineKeyboardButton().setText("Easy").setCallbackData("3"));

            final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup()
                .setKeyboard(Collections.singletonList(keyboard));

            inlineKeyboardMarkup.setKeyboard(Collections.singletonList(keyboard));

            final SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText())
                    .setReplyMarkup(inlineKeyboardMarkup);

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
        return "1360576894:AAFKVForkADH4dW58RkVGbn-9JdRXXW-Vf8";
    }

}
