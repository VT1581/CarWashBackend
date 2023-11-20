package com.saur.userAuthentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.na.userAuthentication.models.User;
import com.na.userAuthentication.repository.UserRepository;

class UserAuthenticationRepository {
	@Autowired
    private UserRepository userRepository;

 

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
    }

 

    @Test
    public void testFindByUsername() {
        String username = "user1";
        User expectedUser = new User();
        expectedUser.setUsername(username);

 

        when(userRepository.findByUsername(username)).thenReturn(null);

 

        Optional<User> result = userRepository.findByUsername(username);

 

        assertNotNull(result);
//        assertEquals(username, result.getUsername());
    }
	

}
