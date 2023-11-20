//package com.example.demo;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.BeforeEach;
////import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.example.demo.controller.WashPackController;
//import com.example.demo.model.Promocode;
//import com.example.demo.model.WashPack;
//import com.example.demo.repository.WashPackRepo;
//import com.example.demo.restClients.PromocodeClient;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//class WashpackControllerTest {
//	private MockMvc mockMvc;
//
//    @InjectMocks
//    private WashPackController washPackController;
//
//    @Mock
//    private PromocodeClient promocodeClient;
//
//    @Mock
//    private WashPackRepo washpackrepo;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(washPackController).build();
//    }
//
//    @Test
//    public void testCreate() throws Exception {
//       
//        WashPack washPack = new WashPack();
//        washPack.setPromocodeCode("SAMPLE_CODE");
//
//      
//        Promocode promocode = new Promocode();
//        promocode.setDiscount(new BigDecimal("10.0")); // Assuming a 10% discount
//
//        when(promocodeClient.getPromocode("SAMPLE_CODE")).thenReturn(promocode);
//        when(washpackrepo.save(washPack)).thenReturn(washPack);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/washpack")
//                .content(asJsonString(washPack))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        // Verify that the WashPack price is updated correctly
//        verify(washpackrepo, times(1)).save(washPack);
//        assertEquals(new BigDecimal("90.0"), washPack.getWashpackPrice()); // 10% discount applied
//    }
//
//    private String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//
//
//
//	}
//	
//
//
//
//
//
//
