package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beans.xml")) {

            // prototype : 두번 생성자를 호출.
            // 매번 요청될 때마다 새로운 인스턴스가 생성되어 컨테이너가 해당 빈 인스턴스의 생명주기 관리x -> destroy()실행 안됨.
            System.out.println("---------");
            new GreetingService(context.getBean("koreanGreeter", Greeter.class)).greet();
            System.out.println("---------");
            new GreetingService(context.getBean("koreanGreeter", Greeter.class)).greet();

            // sigleton : 처음 한번만 생성자 호출.
            // 컨테이너 종료 시destroy도 마지막에 호출되어 cleanup작업 수행.
            System.out.println("---------");
            new GreetingService(context.getBean("englishGreeter", Greeter.class)).greet();
            System.out.println("---------");
            new GreetingService(context.getBean("englishGreeter", Greeter.class)).greet();
            System.out.println("---------");
        }
    }
}
