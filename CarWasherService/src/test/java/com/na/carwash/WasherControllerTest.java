package com.na.carwash;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.na.carwash.controller.WasherController;
import com.na.carwash.entity.Washer;
import com.na.carwash.service.WasherService;

@SpringBootTest
class WasherControllerTest {
	
	@InjectMocks
	private WasherController controller;
	
	@Mock
	private WasherService service;
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void testAddWasher() {
       Washer washerToAdd = new Washer(1,"RAM","PAVI@123","ap","pavi@gmail.com");
        when(service.addNewWasher(washerToAdd)).thenReturn(washerToAdd);
 
        ResponseEntity<Washer> response = controller.addWasher(washerToAdd);
 
        verify(service, times(1)).addNewWasher(washerToAdd);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(washerToAdd, response.getBody());
    }
	
	@Test
    public void testGetWasherByName() {
        String name = "John";
        Washer washer = new Washer();
 
        Mockito.when(service.findByName(name)).thenReturn(washer);
 
        ResponseEntity<Washer> response = controller.getWasherByName(name);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(washer, response.getBody());
    }
	
	@Test
    public void testGetAllWashers() {
        List<Washer> washers = new ArrayList<>();
        washers.add(new Washer());
        washers.add(new Washer());
 
        Mockito.when(service.getAllWashers()).thenReturn(washers);
 
        ResponseEntity<List<Washer> > response = controller.getAllWashers();
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(washers, response.getBody());
    }
	
	 @Test
	    public void testUpdateProfile() {
	        int id = 1;
	        Washer updatedWasher = new Washer();
	        updatedWasher.setId(id);
	        updatedWasher.setName("Updated Name");
 
	        Mockito.when(service.updateProfile(updatedWasher, id)).thenReturn(updatedWasher);
 
	        ResponseEntity<Washer> response = controller.updateProfile(id, updatedWasher);
 
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(updatedWasher, response.getBody());
	    }
 
	    @Test
	    public void testUpdateProfileNotFound() {
	        int id = 1;
	        Washer updatedWasher = new Washer();
	        updatedWasher.setId(id);
	        updatedWasher.setName("Updated Name");
 
	        Mockito.when(service.updateProfile(updatedWasher, id)).thenReturn(null);
 
	        ResponseEntity<Washer> response = controller.updateProfile(id, updatedWasher);
 
	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	    }
	

}
