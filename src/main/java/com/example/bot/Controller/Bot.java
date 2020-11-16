package com.example.bot;

import java.util.Collections;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            final KeyboardRow keyboard = new KeyboardRow();
            keyboard.add("Again");
            keyboard.add("Hard");
            keyboard.add("Good");
            keyboard.add("Easy");

            final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(Collections.singletonList(keyboard))
                    .setResizeKeyboard(true);

            final SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText())
                    .setReplyMarkup(replyKeyboardMarkup);

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
