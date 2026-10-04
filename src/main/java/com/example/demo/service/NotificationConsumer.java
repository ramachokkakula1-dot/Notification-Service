package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.demo.entity.NotificationLog;
import com.example.demo.repo.NotificationRepository;

public class NotificationConsumer {
	private static final Logger log = LoggerFactory.getLogger(NotificationConsumer.class);
	private final NotificationRepository notificationRepository;

	public NotificationConsumer(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	@KafkaListener(topics = "order-status-updated", groupId = "notification-service-group")
	public void listen(OrderStatusEvent event) {
		String text = "CONFIRMED".equals(event.getStatus())
				? "Your order " + event.getOrderId() + " has been confirmed!"
				: "Your order " + event.getOrderId() + " was rejected: " + event.getMessage();

		NotificationLog logEntry = new NotificationLog(event.getOrderId(), event.getStatus(), text);
		notificationRepository.save(logEntry);

		// in a real project this is where you'd call an email/SMS provider
		log.info("NOTIFICATION SENT -> {}", text);
	}
}
