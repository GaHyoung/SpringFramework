package com.nhnacademy.edu.springframework.greeting.service;

public class KoreanGreeter implements Greeter{

    public KoreanGreeter() { //bean scope test!
//        System.out.println("KoreanGreeter initiated!!");
    }

    public void init() { //객체의 생명주기 callbacks - 초기화 test
        System.out.println("KoreanGreeter init called!!");
    }

    @Override
    public boolean sayHello() {
        System.out.println("안녕 세상!");
        return true;
    }

    public void destroy() { //객체의 생명주기 callbacks - 소멸 test
        System.out.println("KoreanGreeter destroy called!!");
    }

}
