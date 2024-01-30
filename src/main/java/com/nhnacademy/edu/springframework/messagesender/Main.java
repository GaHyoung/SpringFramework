package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.messagesender.config.ApplicationConfig;
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
        //해당 패키지 안에 있는 @Configuration을 찾아간다.
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.messagesender");

        context.getBean("dbms", String.class).isEmpty();

    }
}
