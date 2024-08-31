package com.kristellar.shadow_trace.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @GetMapping("/call_logs")
    public String callLogs() {
        return "call logs";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/fb")
    public String fb() {
        return "fb";
    }

    @GetMapping("/insta")
    public String insta() {
        return "insta";
    }

    @GetMapping("/otp")
    public String otp() {
        return "otp";
    }

    @GetMapping("/photos")
    public String photos() {
        return "photos";
    }

    @GetMapping("/recording")
    public String recording() {
        return "recording";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/snap")
    public String snap() {
        return "snap";
    }

    @GetMapping("/tele")
    public String tele() {
        return "tele";
    }

    @GetMapping("/whatsapp")
    public String whatsapp() {
        return "whatsapp";
    }

    @GetMapping("/x")
    public String x() {
        return "x";
    }
}
