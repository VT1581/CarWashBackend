package com.na.carwash.service;

import java.util.List;

import com.na.carwash.entity.Washer;

public interface WasherService {

	public String washRequestFromCustomer();

	public Washer findByName(String name);

	public Washer updateProfile(Washer washer, int id);

	public Washer addNewWasher(Washer washer);

	public List<Washer> getAllWashers();
	
	

	
}
