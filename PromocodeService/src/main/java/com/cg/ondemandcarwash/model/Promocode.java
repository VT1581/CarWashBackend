package com.cg.ondemandcarwash.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Document("promocode")
public class Promocode {
	
	@Id
//	private Long id;
	@NotBlank(message = "Code is required")
	private String code;
	@NotNull(message = "Discount is required")
	private BigDecimal discount;
	@NotBlank(message = "Expiration Date is required")
	private String expDate;
	

	
	public Promocode(String code, BigDecimal discount, String expDate) {
		super();
		this.code = code;
		this.discount = discount;
		this.expDate = expDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
		

}
