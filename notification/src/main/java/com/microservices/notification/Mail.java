package com.microservices.notification;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mail")
public class Mail {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "_to", columnDefinition = "VARCHAR(255)")
    private String to;
    @Column(name = "subject", columnDefinition = "TEXT")
    private String subject;
    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    private Integer customerId;
}






