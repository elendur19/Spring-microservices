package com.robic.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void createNewNotification(Integer customerId) {
            notificationRepository.save(
                    Notification.builder()
                            .customerId(customerId)
                            .sentAt(LocalDateTime.now())
                            .message("This is microservices message.")
                            .customerEmail("random-email@gmail.com")
                            .customerPhoneNumber("0988999")
                            .build()
            );
    }
}