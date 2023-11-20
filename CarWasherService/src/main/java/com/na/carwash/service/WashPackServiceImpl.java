package com.na.carwash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.carwash.entity.WashPacks;
import com.na.carwash.exception.WashPackNotFoundException;
import com.na.carwash.repository.WashPackRepository;

@Service
public class WashPackServiceImpl implements WashPackService {
	
	@Autowired
	WashPackRepository cwRepository;

	@Override
	public List<WashPacks> getAllWashPacks() {
			
			List<WashPacks> washPack = new ArrayList<WashPacks>();
			cwRepository.findAll().forEach(packDetails -> washPack.add(packDetails));
			
			return washPack;
		
	}

	@Override
	public WashPacks addWashPacks(WashPacks washPacks) {
		cwRepository.save(washPacks);
		return washPacks;
	}

	@Override
	public boolean deleteById(String washPackId) throws WashPackNotFoundException{
		Optional<WashPacks> details= cwRepository.findById(washPackId);
		if(details.isPresent()) {
			cwRepository.delete(details.get());
			return true;
		}
		throw new WashPackNotFoundException("There is no washPacks found by given by id");
	}

	@Override
	public WashPacks updateWashPacks(WashPacks washPacks){
		cwRepository.save(washPacks);
		return washPacks;
	}
	@Override
	public WashPacks findWashpacksById(String packId) {
		return cwRepository.findById(packId).orElse(null);
	}

}
