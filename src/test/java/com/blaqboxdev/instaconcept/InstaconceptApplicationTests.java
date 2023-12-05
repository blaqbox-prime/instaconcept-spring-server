package com.blaqboxdev.instaconcept;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blaqboxdev.instaconcept.models.User;
import com.blaqboxdev.instaconcept.models.UserLoginRequest;
import com.blaqboxdev.instaconcept.repositories.UserRepository;
import com.blaqboxdev.instaconcept.services.AuthService;

@SpringBootTest
class InstaconceptApplicationTests {

	@Test
	void contextLoads() {
	}

	
}
