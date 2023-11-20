package com.na.carwash.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Document(collection = "WashPacks")
public class WashPacks {

	@Id
	private String washpackId;
	@NotBlank(message = "Wash Pack Name is required")
	private String washpackName;
	@NotNull(message = "Wash Pack Price is required")
    @PositiveOrZero(message = "Wash Pack Price must be a positive or zero value")
	private double washpackPrice;
	@Size(max = 255, message = "Description can be at most 255 characters")
	private String description;
	
	
	public WashPacks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WashPacks(String washpackId, String washpackName, double washpackPrice, String description) {
		super();
		this.washpackId = washpackId;
		this.washpackName = washpackName;
		this.washpackPrice = washpackPrice;
		this.description = description;
	}
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
	public double getWashpackPrice() {
		return washpackPrice;
	}
	public void setWashpackPrice(double washpackPrice) {
		this.washpackPrice = washpackPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
