package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;

public class MessageSendService {
    private MessageSender messageSender;

    //MessageSendService는 컴파일시에 어떤 MessageSender를 사용할지 결정하지 않음
    public MessageSendService(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
