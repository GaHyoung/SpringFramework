package com.nhnacademy.edu.springframework.greeting.config;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class MainConfig {

    //KoreanGreeter 를 JavaConfig 로 변경하기
    @Bean("koreanGreeter")
    public Greeter koreanGreeter(){
        return new KoreanGreeter();
    }

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(koreanGreeter());
    }
}
