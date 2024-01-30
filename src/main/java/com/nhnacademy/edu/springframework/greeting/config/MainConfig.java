package com.nhnacademy.edu.springframework.greeting.config;

import com.nhnacademy.edu.springframework.greeting.GreetingService;
import com.nhnacademy.edu.springframework.greeting.service.EnglishGreeter;
import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.greeting"})
@PropertySource("classpath:greeter.properties")
public class MainConfig {

    //KoreanGreeter 를 JavaConfig 로 변경하기
    @Bean("koreanGreeter")
    public Greeter koreanGreeter(){
        return new KoreanGreeter();
    }
    @Bean("englishGreeter")
    public Greeter englishGreeter(){
        return new EnglishGreeter();
    }
    @Bean
    public GreetingService greetingService(){
        return new GreetingService(englishGreeter());
    }
}
