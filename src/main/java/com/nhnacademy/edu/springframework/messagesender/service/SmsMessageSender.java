package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;

public class SmsMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        System.out.printf("SMS Message Sent to %s : %s %n", user.getPhoneNumber(), message);
    }
}
