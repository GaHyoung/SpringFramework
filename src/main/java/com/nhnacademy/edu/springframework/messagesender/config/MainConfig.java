package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.greeting.service.EnglishGreeter;
import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import com.nhnacademy.edu.springframework.messagesender.service.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
@Configuration //Spring IoC컨테이너에게 애플리케이션의 구성 정보를 제공.
//이 위치에 있는 Bean Scanning 의 대상이 되는 어노테이션들(Component, Controller, Service, Repository) 확인.
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
//@Value
@PropertySource("classpath:name.properties")
@EnableAspectJAutoProxy // @AspectJ 지원을 활성화 하려면 Java @configuration 에서 @EnableAspectJAutoProxy 를 사용하여 설정
public class MainConfig {

    //SmsMessageSender 를 JavaConfig 를 사용하도록 수정
    //생성자 주입방식
    private MessageSender smsMessageSender;
    private String message;

    public MainConfig(
            //@Autowired 및 @Value 어노테이션을 사용하여 다른 빈들 간의 의존성을 주입
            //@Qualifier는 Spring 프레임워크에서 빈을 주입할 때 여러 후보 빈 중에서 어떤 빈을 선택할지 명시적으로 지정할 때 사용하는 어노테이션.
            @Qualifier("smsMessageSender") MessageSender smsMessageSender,
            @Value("${from}") String message
    ){
        this.smsMessageSender = smsMessageSender;
        this.message = message;
    }

    @Bean //이름지정 안할 시 메서드 이름으로 기본 지정.
    //MessageSendService 클래스의 생성자를 통해 smsMessageSender와 message에 대한 의존성을 주입
    public MessageSendService messageSenderService(){
        return new MessageSendService(smsMessageSender, message);
    }
}
