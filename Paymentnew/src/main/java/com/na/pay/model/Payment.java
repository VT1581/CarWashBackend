package com.na.pay.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Document(collection = "pay")
public class Payment {
	
	@Id
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank(message = "PaymentStatus is required")
	private String paystatus;
	@NotNull(message = "Amount is required")
    @PositiveOrZero(message = "Amount must be a positive or zero value")
	private double amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Payment(String name, String email, String paystatus, double amount) {
		this.name = name;
		this.email = email;
		this.paystatus = paystatus;
		this.amount = amount;
	}
	public Payment() {
	}
	
	
	
	

}
