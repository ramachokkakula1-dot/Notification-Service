package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NotificationLog;

public interface NotificationRepository extends JpaRepository<NotificationLog, Long> {
}
