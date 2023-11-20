package com.na.pay;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.na.pay.controller.PaymentController;
import com.na.pay.model.Payment;
import com.na.pay.service.PaymentService;

class PaymentnewControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private PaymentService paymentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPayment() {
        Payment mockPayment = new Payment();
        mockPayment.setName("TestPayment");
        when(paymentService.addpay(any(Payment.class))).thenReturn(mockPayment);
        Payment payment = paymentController.addpay(mockPayment);
        assertEquals("TestPayment", payment.getName());
    }
    
    @Test
    public void testGetPayment() {
        String name = "TestPayment";
        Payment mockPayment = new Payment();
        mockPayment.setName(name);
        when(paymentService.getpay(name)).thenReturn(mockPayment);
        Payment payment = paymentController.getpay(name);
        assertEquals(name, payment.getName());
    }

}
