package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {

        User user = new User(
                "mnb2457@naver.com",
                "010-1111-1111"
        );

        String prototypeMessage = "Prototype";
        String singletonMessage = "Singleton";

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            // sigleton : 처음 한번만 생성자 호출.
            // 컨테이너 종료 시destroy도 마지막에 호출되어 cleanup작업 수행.
            System.out.println("---------");
            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class)).doMessage(user, singletonMessage);
            System.out.println("---------");
            new MessageSendService(context.getBean("emailMessageSender", MessageSender.class)).doMessage(user, singletonMessage);

            // prototype : 두번 생성자를 호출.
            // 매번 요청될 때마다 새로운 인스턴스가 생성되어 컨테이너가 해당 빈 인스턴스의 생명주기 관리x -> destroy()실행 안됨.
            System.out.println("---------");
            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class)).doMessage(user, prototypeMessage);
            System.out.println("---------");
            new MessageSendService(context.getBean("smsMessageSender", MessageSender.class)).doMessage(user, prototypeMessage);
            System.out.println("---------");
        }
    }
}
