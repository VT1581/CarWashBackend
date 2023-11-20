package com.na.carwash;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.na.carwash.entity.WashPacks;
import com.na.carwash.repository.WashPackRepository;

@SpringBootTest
class WashPackRepositoryTest {

	@Mock
    private WashPackRepository wpRepository;

	@Test
    public void testFindAll() {
        // Mock data
		WashPacks wp1 = new WashPacks("1","Interior cleaning",2300,"deep car cleaning inside and outside");
		WashPacks wp2 = new WashPacks("2","Wheel and tire clean",2300,"exchange wheel and clean");
        List<WashPacks> washpacks = new ArrayList<>();
        washpacks.add(wp1);
        washpacks.add(wp2);

        when(wpRepository.findAll()).thenReturn(washpacks);

        List<WashPacks> result = wpRepository.findAll();
        assertEquals(2, result.size());

    }
	


	

 

}
