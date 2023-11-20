package com.na.carwash.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection="washers")
public class Washer {

	@Id
	private int id;
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	@NotBlank(message = "Address is required")
	private String address;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	public Washer(int id,String name, String password,String address,String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
	}
	public Washer() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
