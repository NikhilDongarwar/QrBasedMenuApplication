package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.entity.Notification;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendNotification(Notification notification) {
    	System.out.println("notifi is "+notification);
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }
}
