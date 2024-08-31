package com.kristellar.shadow_trace.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
