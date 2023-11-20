package com.na.carwash.service;

import java.util.List;

import com.na.carwash.entity.WashPacks;
import com.na.carwash.exception.WashPackNotFoundException;

import jakarta.validation.Valid;

public interface WashPackService {

	

	WashPacks addWashPacks(WashPacks washPacks);
	List<WashPacks> getAllWashPacks();
	boolean deleteById(String washPackId) throws WashPackNotFoundException;
	WashPacks updateWashPacks(WashPacks washPacks);
	WashPacks findWashpacksById(String packId);
	
	
}
