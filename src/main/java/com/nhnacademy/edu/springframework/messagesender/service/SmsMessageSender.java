package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SmsMessageSender implements MessageSender {

    public SmsMessageSender(){

    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.printf("SMS Message Sent to %s : %s %n", user.getPhoneNumber(), message);
    }

    private void init() {
        System.out.println("init method called in SmsMessageSender");
    }

    private void destroy() {
        System.out.println("destroy method called in SmsMessageSender");
    }
}
