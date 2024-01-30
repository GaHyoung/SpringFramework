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

@Configuration //@Bean을 등록
//이 위치에 있는 Bean Scanning 의 대상이 되는 어노테이션들(Component, Controller, Service, Repository) 확인.
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
//@Value
@PropertySource("classpath:name.properties")
public class MainConfig {

    //SmsMessageSender 를 JavaConfig 를 사용하도록 수정
    //생성자 주입방식
    private MessageSender smsMessageSender;
    private String message;

    public MainConfig(
            //@Qualifier는 Spring 프레임워크에서 빈을 주입할 때 여러 후보 빈 중에서 어떤 빈을 선택할지 명시적으로 지정할 때 사용하는 어노테이션
            @Qualifier("smsMessageSender") MessageSender smsMessageSender,
            @Value("${from}") String message
    ){
        this.smsMessageSender = smsMessageSender;
        this.message = message;
    }
//    @Autowired
//    @Qualifier("smsMessageSender")
//    private MessageSender smsMessageSender;
//
//    @Value("${from}")
//    private String message;

    @Bean //이름지정 안할 시 메서드 이름으로 기본 지정.
    public MessageSendService messageSenderService(){
        return new MessageSendService(smsMessageSender, message);
    }
}
