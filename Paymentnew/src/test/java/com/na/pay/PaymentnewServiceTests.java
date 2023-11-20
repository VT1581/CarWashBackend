package com.na.pay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.na.pay.model.Payment;
import com.na.pay.repo.PaymentRepository;
import com.na.pay.service.PaymentService;

@SpringBootTest
class PaymentnewServiceTests {
	
	 @InjectMocks
	    private PaymentService paymentService;

	    @Mock
	    private PaymentRepository paymentRepository;

	    @BeforeEach
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	    @Test
	    public void testAddPayment() {
	        Payment mockPayment = new Payment();
	        mockPayment.setName("TestPayment");
	        when(paymentRepository.save(any(Payment.class))).thenReturn(mockPayment);
	        Payment payment = paymentService.addpay(mockPayment);
	        assertEquals("TestPayment", payment.getName());
	    }
	    
	    @Test
	    public void testGetPayment() {
	        String name = "TestPayment";
	        Payment mockPayment = new Payment();
	        mockPayment.setName(name);
	        when(paymentRepository.findById(name)).thenReturn(Optional.of(mockPayment));
	        Payment payment = paymentService.getpay(name);
	        assertEquals(name, payment.getName());	    }

}
