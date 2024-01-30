package com.nhnacademy.edu.springframework.greeting.config;

import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    //KoreanGreeter 를 JavaConfig 로 변경하기
    @Bean("koreanGreeter")
    public Greeter koreanGreeter(){
        return new KoreanGreeter();
    }
}
