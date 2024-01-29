package com.nhnacademy.edu.springframework.greeting.service;

public class EnglishGreeter implements Greeter{

    @Override
    public boolean sayHello() {
        System.out.println("Hello World!");
        return true;
    }

}
