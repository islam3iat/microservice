package com.microservices.client;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;



public record MailDto(
        @NotNull @Email @NotEmpty @NotBlank
        String to,
        String subject,
        String text,
        @NotNull @NotEmpty @NotBlank
        Integer customerId
) {
}