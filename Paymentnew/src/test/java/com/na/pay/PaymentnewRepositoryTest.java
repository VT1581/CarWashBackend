package com.na.pay;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.na.pay.model.Payment;
import com.na.pay.repo.PaymentRepository;



@DataMongoTest
class PaymentnewRepositoryTest {

	@Autowired
    private PaymentRepository paymentRepository;



    @Test
    public void testFindByPaymentName() {
        Payment payment = new Payment("radha","radha@gmail.com","pending",300.00);
        paymentRepository.save(payment);
        Payment foundpayment = paymentRepository.findByName("radha");
        assertNotNull(foundpayment);
        assertEquals("pending", foundpayment.getPaystatus());
    }

}
