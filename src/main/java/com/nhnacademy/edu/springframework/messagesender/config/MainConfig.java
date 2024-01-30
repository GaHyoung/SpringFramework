package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfig {

    //SmsMessageSender 를 JavaConfig 를 사용하도록 수정
    @Bean("smsMessageSender")
    public MessageSender smsMessageSender(){
        return new SmsMessageSender();
    }
}
