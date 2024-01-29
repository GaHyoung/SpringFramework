package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.messagesender.service.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "mnb2457@naver.com",
                "010-1111-1111"
        );

        String message = "Hello";
        new MessageSendService(new EmailMessageSender()).doMessage(user, message);
        new MessageSendService(new SmsMessageSender()).doMessage(user, message);

    }
}
