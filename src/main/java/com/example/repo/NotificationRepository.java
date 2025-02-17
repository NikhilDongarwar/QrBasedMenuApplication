package com.example.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByisreadFalse();
}