package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMain {
    public static void main(String[] args) {
        //GreetingService 빈을 greetingService 으로 빈을 선언하였기 때문에 런타임에 ApplicationContext 에 GreetingService객체가 생성되어 등록되어 있음.(IoC)
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            GreetingService service = context.getBean("greetingService", GreetingService.class);
            service.greet();
        }


    }
}