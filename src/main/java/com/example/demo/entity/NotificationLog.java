package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotificationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String orderId;
	private String status;
	private String message;
	private LocalDateTime sentAt;

	public NotificationLog() {
	}

	public NotificationLog(String orderId, String status, String message) {
		this.orderId = orderId;
		this.status = status;
		this.message = message;
		this.sentAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}
}
