package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.Greeter;

public class GreetingService {

    // final은 객체를 생성한뒤 greeter 변수에 값을 할당할 수 없다.
    // private final Greeter greeter;
    private Greeter greeter;

    // Constructor Injection
    // 생성자 주입 방식을 사용하므로, 주입 대상 스프링빈에 적절한 생성자가 필요하다.
    // GreetingService 가 Greeter 를 생성자 인자로 받을 수 있도록 생성자를 추가
    // GreetingService를 bean으로 등록해 생성자를 이용하여 koreanGreeter 빈을 주입.
    public GreetingService(Greeter greeter){
        this.greeter = greeter;
    }

    // Setter Injection
    // 기본 생성자 필요
    public GreetingService(){
    }

    public void setGreeter(Greeter greeter){
        System.out.println("setGreeter invoked");
        this.greeter = greeter;
    }

    public boolean greet() {
        // 인터페이스의 메소드를 호출하지만 실제 구현 객체의 메소드가 실행됩니다.
        return greeter.sayHello();
    }

}
