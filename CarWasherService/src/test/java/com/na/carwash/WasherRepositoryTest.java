package com.na.carwash;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.na.carwash.entity.Washer;
import com.na.carwash.repository.WasherRepository;

@SpringBootTest
class WasherRepositoryTest {

	@Mock
    private WasherRepository repository;
 
	@Test
    public void testFindAll() {
        // Mock data
	 Washer washer1= new Washer(1,"RAM","PAVI@123","ap","pavi@gmail.com");
	 Washer washer2 = new Washer(2,"RAM","PAVI@123","ap","pavi@gmail.com");
        List<Washer> washers = new ArrayList<>();
        washers.add(washer1);
        washers.add(washer2);
 
        when(repository.findAll()).thenReturn(washers);
 
 
        List<Washer> result = repository.findAll();
        assertEquals(2, result.size());
    }

}
