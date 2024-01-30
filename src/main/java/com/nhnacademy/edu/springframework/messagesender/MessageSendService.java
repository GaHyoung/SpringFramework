package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.service.Greeter;
import com.nhnacademy.edu.springframework.messagesender.annotaion.Sms;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSendService {
    private MessageSender messageSender;

    //MessageSendService는 컴파일시에 어떤 MessageSender를 사용할지 결정하지 않음
    @Autowired
    public MessageSendService(@Sms MessageSender messageSender){
        this.messageSender = messageSender;
    }

    //setter injection
    public MessageSendService(){
    }

    public void setSmsMessageSender(MessageSender messageSender) {
        System.out.println("setMessageSender invoked");
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
