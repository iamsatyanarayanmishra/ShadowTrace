package com.kristellar.shadow_trace.backend.services;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
