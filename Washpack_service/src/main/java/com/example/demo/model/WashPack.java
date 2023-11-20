package com.example.demo.model;

import java.math.BigDecimal;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
@Document("washpack")
public class WashPack {
	@Id
	private String washpackId;
	@NotBlank(message = "Wash Pack Name is required")
	private String washpackName;
	@Size(max = 255, message = "Description can be at most 255 characters")
	private String description;
	@NotNull(message = "Wash Pack Price is required")
    @PositiveOrZero(message = "Wash Pack Price must be a positive or zero value")
	private BigDecimal washpackPrice;
	@NotBlank(message = "Code is required")
	private String promocodeCode;
	public String getWashpackId() {
		return washpackId;
	}
	public void setWashpackId(String washpackId) {
		this.washpackId = washpackId;
	}
	public String getWashpackName() {
		return washpackName;
	}
	public void setWashpackName(String washpackName) {
		this.washpackName = washpackName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public @NotNull(message = "Wash Pack Price is required") @PositiveOrZero(message = "Wash Pack Price must be a positive or zero value") BigDecimal getWashpackPrice() {
		return washpackPrice;
	}
	public void setWashpackPrice(@NotNull(message = "Wash Pack Price is required") @PositiveOrZero(message = "Wash Pack Price must be a positive or zero value") BigDecimal washpackPrice) {
		this.washpackPrice = washpackPrice;
	}
	public String getPromocodeCode() {
		return promocodeCode;
	}
	public void setPromocodeCode(String promocodeCode) {
		this.promocodeCode = promocodeCode;
	}
	public WashPack(String washpackId, @NotBlank(message = "Wash Pack Name is required") String washpackName,
			@Size(max = 255, message = "Description can be at most 255 characters") String description,
			@NotNull(message = "Wash Pack Price is required") @PositiveOrZero(message = "Wash Pack Price must be a positive or zero value") @NotNull(message = "Wash Pack Price is required") @PositiveOrZero(message = "Wash Pack Price must be a positive or zero value") BigDecimal washpackPrice,
			@NotBlank(message = "Code is required") String promocodeCode) {
		this.washpackId = washpackId;
		this.washpackName = washpackName;
		this.description = description;
		this.washpackPrice = washpackPrice;
		this.promocodeCode = promocodeCode;
	}
	public WashPack() {
	}
	
	

	
}
