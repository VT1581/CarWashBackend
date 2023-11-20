package com.na.carwash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.na.carwash.entity.WashPacks;
import com.na.carwash.exception.WashPackNotFoundException;
import com.na.carwash.repository.WashPackRepository;
import com.na.carwash.service.WashPackServiceImpl;

class WashPackServiceTest {
	
	 	@InjectMocks
	    private WashPackServiceImpl washPackService;

	    @Mock
	    private WashPackRepository washPackRepository;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void testGetAllWashPacks() {
	        
	        List<WashPacks> mockWashPacks = new ArrayList<>();
	        when(washPackRepository.findAll()).thenReturn(mockWashPacks);

	        List<WashPacks> result = washPackService.getAllWashPacks();

	        assertEquals(0, result.size());
	    }
	    
	    @Test
	    public void testAddWashPacks() {
	      
	        WashPacks washPack = new WashPacks();
	        when(washPackRepository.save(washPack)).thenReturn(washPack);

	        WashPacks result = washPackService.addWashPacks(washPack);

	        assertNotNull(result);
	    }
	    
	    @Test
	    public void testDeleteById() throws WashPackNotFoundException {
	        
	        String washPackId = "1";
	        Optional<WashPacks> optionalWashPack = Optional.of(new WashPacks());
	        when(washPackRepository.findById(washPackId)).thenReturn(optionalWashPack);

	        boolean result = washPackService.deleteById(washPackId);

	        assertTrue(result);
	        verify(washPackRepository, times(1)).delete(optionalWashPack.get());
	    }

	    @Test
	    public void testDeleteByIdWashPackNotFound() {
	        
	        String washPackId = "2";
	        Optional<WashPacks> optionalWashPack = Optional.empty();
	        when(washPackRepository.findById(washPackId)).thenReturn(optionalWashPack);

	        assertThrows(WashPackNotFoundException.class, () -> washPackService.deleteById(washPackId));
	    }

	    @Test
	    public void testUpdateWashPacks() {
	       
	        WashPacks washPack = new WashPacks();
	        when(washPackRepository.save(washPack)).thenReturn(washPack);

	        WashPacks result = washPackService.updateWashPacks(washPack);

	        assertNotNull(result);
	    }
	

}
