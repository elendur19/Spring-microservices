package com.robic.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping(path = "{customerId}")
    public void createNewNotification(
            @PathVariable("customerId") Integer customerId ) {
        log.info("Incoming notification request for customer with id: {}", customerId);
        notificationService.createNewNotification(customerId);
    }
}
