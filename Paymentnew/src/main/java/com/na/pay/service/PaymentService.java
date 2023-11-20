package com.na.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.na.pay.model.Payment;
import com.na.pay.repo.PaymentRepository;

@Service
public class PaymentService {
	
	 @Autowired
	 private PaymentRepository paymentRepository;
	 
	public Payment addpay(Payment pay) {
		Payment payment=paymentRepository.save(pay);
		return payment;
	}
	
	
	public Payment getpay(String name) {
		Payment pay=paymentRepository.findById(name).get();
		return pay;
	}

}
