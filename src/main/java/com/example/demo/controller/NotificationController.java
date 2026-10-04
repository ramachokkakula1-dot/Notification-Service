package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.NotificationLog;
import com.example.demo.repo.NotificationRepository;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	private final NotificationRepository notificationRepository;

	public NotificationController(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	@GetMapping
	public List<NotificationLog> getAll() {
		return notificationRepository.findAll();
	}
}
