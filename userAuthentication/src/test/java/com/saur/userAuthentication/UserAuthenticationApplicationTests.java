package com.saur.userAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.na.userAuthentication.models.User;
import com.na.userAuthentication.repository.UserRepository;
import com.na.userAuthentication.security.UserDetailsServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@SpringBootTest

class UserAuthenticationApplicationTests {
	
	@InjectMocks
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	 @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        userDetailsServiceImpl = new UserDetailsServiceImpl(userRepository);
	    }
	
	@Test
    public void testLoadUserByUsername_ExistingUser() {
        // Arrange
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword"); // Set other user details as needed
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

        // Act
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("testUser");

        // Assert
        assertEquals("testUser", userDetails.getUsername());
       
    }
	
	@Test
	public void testLoadUserByUsername_NonExistingUser() {
	    // Arrange
	    when(userRepository.findByUsername("nonExistingUser")).thenReturn(Optional.empty());

	    // Act and Assert
	    // Verify that a UsernameNotFoundException is thrown for a non-existing user.
	    assertThrows(UsernameNotFoundException.class, () -> {
	        userDetailsServiceImpl.loadUserByUsername("nonExistingUser");
	    });
	}
}
