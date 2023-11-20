package com.na.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.na.pay.model.Payment;
import com.na.pay.repo.PaymentRepository;
import com.na.pay.service.PaymentService;

@RestController
@CrossOrigin("http://localhost:4200")
public class PaymentController {
	
	@Autowired
	public PaymentService paymentService;
	
	@PostMapping("/addpayment")
	public Payment addpay(@RequestBody Payment pay) {
//		pay.setPaystatus("pending");
		return paymentService.addpay(pay);
	}
	
	@GetMapping("/getpayment/{name}")
	public Payment getpay(@PathVariable String name) {
		return paymentService.getpay(name);
	}
	

}
