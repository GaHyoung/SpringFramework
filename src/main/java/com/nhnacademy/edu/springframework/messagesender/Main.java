package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.config.DoorayConfig;
import com.nhnacademy.edu.springframework.messagesender.service.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "mnb2457@naver.com",
                "010-1111-1111"
        );

        String message = "hello";

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DoorayConfig.class)) {
            MessageSendService doorayService = context.getBean(MessageSendService.class);
            doorayService.doMessage(user, message);
        }
    }
}
