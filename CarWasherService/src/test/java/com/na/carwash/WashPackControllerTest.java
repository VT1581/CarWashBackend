package com.na.carwash;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.na.carwash.controller.WashPackController;
import com.na.carwash.entity.WashPacks;
import com.na.carwash.exception.WashPackNotFoundException;
import com.na.carwash.service.WashPackService;

class WashPackControllerTest {
	
	@InjectMocks
	private WashPackController wpcontroller;
	
	@Mock
	private WashPackService wpservice;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllWashPacks() {
		WashPacks wp1 = new WashPacks("1","Interior cleaning",2300,"deep car cleaning inside and outside");
		WashPacks wp2 = new WashPacks("2","Wheel and tire clean",2300,"exchange wheel and clean");
		List<WashPacks> washPacks = Arrays.asList(wp1, wp2);

        when(wpservice.getAllWashPacks()).thenReturn(washPacks);

        // Act
        ResponseEntity<List<WashPacks>> response = wpcontroller.getAllWashPacks();

        // Assert
        verify(wpservice, times(1)).getAllWashPacks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
	}
	
	@Test
    public void testAddWashPacks() {
        WashPacks washpackToAdd = new WashPacks("1","Basic wash",3000," includes a high-pressure rinse, soap application");
        when(wpservice.addWashPacks(washpackToAdd)).thenReturn(washpackToAdd);

        ResponseEntity<WashPacks> response = wpcontroller.addWashPacks(washpackToAdd);

        verify(wpservice, times(1)).addWashPacks(washpackToAdd);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(washpackToAdd, response.getBody());
    }
	
	@Test
	public void testUpdateWashPacks() {
	    // Arrange
	    WashPacks washpackToUpdate = new WashPacks("1", "Basic wash", 3000, " includes a high-pressure rinse, soap application");
	    when(wpservice.updateWashPacks(washpackToUpdate)).thenReturn(washpackToUpdate);

	    // Act
	    WashPacks updatedWashpack = wpcontroller.updateWashPacks(washpackToUpdate);

	    // Assert
	    verify(wpservice, times(1)).updateWashPacks(washpackToUpdate);
	    assertEquals(washpackToUpdate, updatedWashpack);
	}
	
	@Test
	public void testDeleteWashPacks() throws WashPackNotFoundException {
	    // Arrange
	    String washpackId = "1";
	    when(wpservice.deleteById(washpackId)).thenReturn(true);

	    // Act
	    boolean deleted = wpcontroller.deleteWashPacks(washpackId);

	    // Assert
	    verify(wpservice, times(1)).deleteById(washpackId);
	    assertTrue(deleted);
	}

}
