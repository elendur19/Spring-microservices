package com.robic.notification;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence")
    private Integer id;
    private Integer customerId;
    private String message;
    private LocalDateTime sentAt;
    private String customerEmail;
    private String customerPhoneNumber;
}
