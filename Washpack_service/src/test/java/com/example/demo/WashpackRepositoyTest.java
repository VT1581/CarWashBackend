package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.WashPack;
import com.example.demo.repository.WashPackRepo;


@SpringBootTest
class WashpackRepositoyTest {

	@Mock
    private WashPackRepo wpRepository;

	@Test
    public void testFindAll() {
        // Mock data
		WashPack wp1 = new WashPack("1","Gold Standard Wash","Our Quick Shine package includes a basic exterior wash and hand drying.", new BigDecimal("123.45"),"ABC12");
		WashPack wp2 = new WashPack("2","Quick Shine","For larger vehicles, our Truck & SUV Special ensures a thorough cleaning",new BigDecimal("124.45"),"XYZ123");
        List<WashPack> washpacks = new ArrayList<>();
        washpacks.add(wp1);
        washpacks.add(wp2);

        when(wpRepository.findAll()).thenReturn(washpacks);

        List<WashPack> result = wpRepository.findAll();
        assertEquals(2, result.size());

    }

}
