package com.na.carwash;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.na.carwash.entity.Washer;
import com.na.carwash.repository.WasherRepository;
import com.na.carwash.service.WasherServiceImpl;

class WasherServiceTest {

	@InjectMocks
    private WasherServiceImpl washerService;

    @Mock
    private WasherRepository washerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByName() {
        // Arrange
        String name = "John Doe";
        Washer mockWasher = new Washer();
        mockWasher.setId(1);
        mockWasher.setName(name);

        when(washerRepository.findAll()).thenReturn(List.of(mockWasher));

        // Act
        Washer result = washerService.findByName(name);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
    }
    
    @Test
    public void testFindByNameWhenNotExists() {
        // Arrange
        String name = "Non-existent Washer";
        when(washerRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        Washer result = washerService.findByName(name);

        // Assert
        assertThat(result).isNull();
    }
    
    @Test
    public void testUpdateProfile() {
        // Arrange
        int id = 1;
        Washer existingWasher = new Washer();
        existingWasher.setId(id);
        existingWasher.setName("John Doe");
        existingWasher.setAddress("123 Main St");
        existingWasher.setEmail("john@example.com");
        existingWasher.setPassword("password");

        Washer updatedWasher = new Washer();
        updatedWasher.setId(id);
        updatedWasher.setName("Updated John Doe");
        updatedWasher.setAddress("456 Elm St");
        updatedWasher.setEmail("updated@example.com");
        updatedWasher.setPassword("updatedPassword");

        when(washerRepository.findById(id)).thenReturn(existingWasher);
        when(washerRepository.save(existingWasher)).thenReturn(existingWasher);

        // Act
        Washer result = washerService.updateProfile(updatedWasher, id);
        
        // Assert
        verify(washerRepository).findById(id);
        verify(washerRepository).save(existingWasher);

        assertEquals(id, result.getId());
        assertEquals(updatedWasher.getName(), result.getName());
        assertEquals(updatedWasher.getAddress(), result.getAddress());
        assertEquals(updatedWasher.getEmail(), result.getEmail());
        assertEquals(updatedWasher.getPassword(), result.getPassword());
    }

    

   

}
