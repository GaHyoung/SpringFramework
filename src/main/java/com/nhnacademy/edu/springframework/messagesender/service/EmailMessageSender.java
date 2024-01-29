package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;

public class EmailMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        System.out.printf("Email Message Sent to %s : %s %n", user.getEmail(), message);
    }
}
