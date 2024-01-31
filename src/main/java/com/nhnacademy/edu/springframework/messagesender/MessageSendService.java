package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSendService {
    @Autowired
    private MessageSender messageSender;

    //MessageSendService는 컴파일시에 어떤 MessageSender를 사용할지 결정하지 않음
    public MessageSendService(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void doMessage(User user, String message){
        messageSender.sendMessage(user, message);
    }
}
