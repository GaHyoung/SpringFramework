package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.messagesender.config.ApplicationConfig;
import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.service.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        User user = new User(
                "mnb2457@naver.com",
                "010-1111-2222"
        );

        String message = "Hello";

        //XML 대신 java 기반 설정을 위해서는 AnnotationConfigApplicationContext 를 사용
        //MainConfig위치에 현재 어떤 Bean 객체들이 관리되고 있는지 확인
        //해당 패키지 안에 있는 @Configuration을 찾아간다.
        try (AnnotationConfigApplicationContext context
                     = new AnnotationConfigApplicationContext(MainConfig.class)) {
            MessageSendService service = context.getBean("messageSenderService", MessageSendService.class);

            service.doMessage(user, message);
        }
    }
}
