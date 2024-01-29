package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMain {
    public static void main(String[] args) {
        User user = new User(
                "mnb2457@naver.com",
                "010-1111-1111"
        );
        String message = "setter injection";

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService messageSendService = context.getBean("mesageSendService2", MessageSendService.class);
            messageSendService.setMessageSender(context.getBean("smsMessageSender", SmsMessageSender.class));

            MessageSendService service = context.getBean("mesageSendService", MessageSendService.class);
            service.doMessage(user, message);
        }
    }
}