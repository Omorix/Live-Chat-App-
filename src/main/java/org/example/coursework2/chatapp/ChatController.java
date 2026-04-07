package org.example.coursework2.chatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        return message;
    }
}
