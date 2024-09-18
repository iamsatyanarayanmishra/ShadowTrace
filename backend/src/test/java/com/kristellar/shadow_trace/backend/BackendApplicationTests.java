package com.kristellar.shadow_trace.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kristellar.shadow_trace.backend.services.EmailService;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EmailService service;

	@Test
	void sendEmailTest(){
		service.sendEmail("imkanhumishra@gmail,com", "This is just a testing mail", "I am working on shadowtrace email service.");
	}
}
