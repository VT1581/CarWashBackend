package com.saur.userAuthentication;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.na.userAuthentication.controllers.AuthController;
import com.na.userAuthentication.models.ERole;
import com.na.userAuthentication.models.Role;
import com.na.userAuthentication.repository.RoleRepository;
import com.na.userAuthentication.security.UserDetailsServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class UserControllerTest {

	@InjectMocks
	private AuthController authController;
	
	@Mock
	private RoleRepository roleRepository;
	
	 
	

}
