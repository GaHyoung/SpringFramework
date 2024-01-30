package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.stereotype.Component;

@Component("emailMessageSender")
public class EmailMessageSender implements MessageSender {
    public EmailMessageSender(){

    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.printf("Email Message Sent to %s : %s %n", user.getEmail(), message);
    }

    private void init() {
        System.out.println("init method called in EmailMessageSender");
    }

    private void destroy() {
        System.out.println("destroy method called in EmailMessageSender");
    }
}
