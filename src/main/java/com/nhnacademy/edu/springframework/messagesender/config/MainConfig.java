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

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
@PropertySource("classpath:name.properties")
public class MainConfig {

    //SmsMessageSender 를 JavaConfig 를 사용하도록 수정
    //필드 주입방식
    @Autowired
    @Qualifier("smsMessageSender")
    private MessageSender smsMessageSender;

    @Value("${from}")
    private String message;

    @Bean
    public MessageSendService messageSenderService(){
        return new MessageSendService(smsMessageSender, message);
    }
}
