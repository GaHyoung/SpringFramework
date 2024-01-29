package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMain {
    public static void main(String[] args) {

        User user = new User(
                "mnb2457@naver.com",
                "010-1111-1111"
        );
        String message = "constructor injection";

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService service = context.getBean("mesageSendService", MessageSendService.class);
            service.doMessage(user, message);
        }

    }
}