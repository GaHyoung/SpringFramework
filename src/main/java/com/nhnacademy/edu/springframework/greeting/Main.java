package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.EnglishGreeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.greeting");

        GreetingService service = context.getBean(GreetingService.class);
        service.greet();
    }
}
