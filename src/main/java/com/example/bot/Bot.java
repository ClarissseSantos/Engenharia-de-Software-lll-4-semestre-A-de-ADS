package com.example.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            final SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
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
