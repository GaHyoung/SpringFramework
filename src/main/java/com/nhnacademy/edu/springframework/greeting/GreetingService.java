package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.Greeter;

public class GreetingService {

    //GreetingService 는 컴파일 타임에 어떤 Greeter 가 실행되는지 알 수 없다.

    private Greeter greeter;

    public GreetingService(Greeter greeter){
        this.greeter = greeter;
    }

    public boolean greet() {
        // 인터페이스의 메소드를 호출하지만 실제 구현 객체의 메소드가 실행됩니다.
        return greeter.sayHello();
    }

}
