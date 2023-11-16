package com.microservices.notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
}