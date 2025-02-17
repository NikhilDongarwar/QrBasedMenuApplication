package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.entity.Notification;
import com.example.repo.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(Notification notification) {
        notificationRepository.save(notification);
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }

    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByisreadFalse();
    }

    public void markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setisRead(true);
        notificationRepository.save(notification);
    }
}