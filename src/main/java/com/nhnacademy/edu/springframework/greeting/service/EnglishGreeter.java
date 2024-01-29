package com.nhnacademy.edu.springframework.greeting.service;

public class EnglishGreeter implements Greeter{

    public EnglishGreeter(){ //bean scope test!
//        System.out.println("EnglishGreeter initiated!!");
    }

    public void init() { //객체의 생명주기 callbacks - 초기화 test
        //XML 빈 설정에서 init-method 에 초기화 메서드 이름을 지정하여 초기화 작업을 등록 가능.
        System.out.println("EnglishGreeter init called!!");
    }

    @Override
    public boolean sayHello() {
        System.out.println("Hello World!");
        return true;
    }

    public void destroy() { //객체의 생명주기 callbacks - 소멸 test
        System.out.println("EnglishGreeter destroy called!!");
    }

}
