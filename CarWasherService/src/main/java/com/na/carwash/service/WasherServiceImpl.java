package com.na.carwash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.carwash.entity.WashPacks;
import com.na.carwash.entity.Washer;
import com.na.carwash.repository.WasherRepository;

@Service
public class WasherServiceImpl implements WasherService {
	
	@Autowired
	private WasherRepository washerRepository;
	
	 

	@Override
	public String washRequestFromCustomer() {
		return "Request accepted/declined";
		
	}

	@Override
	public Washer findByName(String name) {
		
		return washerRepository.findAll().stream().filter(a -> a.getName().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}

	@Override
	public Washer updateProfile(Washer washer, int id) {
		Washer existingWasher = washerRepository.findById(id);

		existingWasher.setName(washer.getName());
		existingWasher.setAddress(washer.getAddress());
		existingWasher.setEmail(washer.getEmail());
		existingWasher.setPassword(washer.getPassword());
		washerRepository.save(existingWasher);

		return existingWasher;
	}

	@Override
	public Washer addNewWasher(Washer washer) {
		washerRepository.save(washer);
		return washer;
	}

	@Override
	public List<Washer> getAllWashers() {
		List<Washer> washer = new ArrayList<Washer>();
		washerRepository.findAll().forEach(details -> washer.add(details));
		
		return washer;
	}

}
