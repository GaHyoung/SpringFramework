package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.EnglishGreeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;

public class Main {
    public static void main(String[] args) {

        //Greeter 객체 생성과 실행은 main 메서드에서 수행
        new GreetingService(new EnglishGreeter()).greet();
        new GreetingService(new KoreanGreeter()).greet();
    }
}
