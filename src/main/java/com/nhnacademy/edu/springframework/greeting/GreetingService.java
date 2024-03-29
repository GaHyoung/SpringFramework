package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.annotaion.Lang;
import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class GreetingService {
    private Greeter greeter;

    @Value("${from}")
    private String from;

    //@Autowire 할때, @Qualifier 를 지정하여 빈의 이름으로 의존성을 주입 할 수 있다.
    @Autowired
    public GreetingService(@Lang Greeter greeter){
        this.greeter = greeter;
    }

    // Setter Injection
    // 기본 생성자 필요
    public GreetingService(){
    }

    //@Required 어노테이션은 빈의 설정(XML이나 Java Config)에서 필수적으로 프로퍼티를 설정해야 함을 나타내기 위해 사용
    // 의존성 주입이 반드시 성공해야 한다는 보장이 필요한 setter 메소드에 @Required 를 설정
    // 주로 프로퍼티에 대한 의존성을 강제할 때 사용
//    @Required

    // setter 메소드에 @Autowired 를 설정하여 의존성을 주입
//    @Autowired
//    public void setKoreanGreeter(Greeter greeter){
//        System.out.println("setGreeter invoked");
//        this.greeter = greeter;
//    }

    public boolean greet() {
        System.out.println("From : " + from);
        return greeter.sayHello();
    }

}
