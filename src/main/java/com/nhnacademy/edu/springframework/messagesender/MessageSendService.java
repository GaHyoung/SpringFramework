package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MessageSendService {
    private MessageSender messageSender;
    private String phoneNumber;

    //MessageSendService는 컴파일시에 어떤 MessageSender를 사용할지 결정하지 않음
    @Autowired
    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender,
                              @Value("${from}") String phoneNumber){
        this.messageSender = messageSender;
        this.phoneNumber = phoneNumber;
    }

    public void setSmsMessageSender(MessageSender messageSender) {
        System.out.println("setMessageSender invoked");
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        user.setPhoneNumber(phoneNumber);
        messageSender.sendMessage(user, message);

    }
}
