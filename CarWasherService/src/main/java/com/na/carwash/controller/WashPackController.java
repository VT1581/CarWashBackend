package com.na.carwash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.na.carwash.entity.WashPacks;
import com.na.carwash.exception.WashPackNotFoundException;
import com.na.carwash.repository.WashPackRepository;
import com.na.carwash.service.WashPackService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/washpacks")
@CrossOrigin("http://localhost:4200")
public class WashPackController {

	@Autowired
	WashPackRepository cwRepository;
	
	@Autowired
	WashPackService washpackService;
	
	@GetMapping("/getAllWashPacks")
	public ResponseEntity<List<WashPacks>> getAllWashPacks(){
		
		List<WashPacks> allPacks = washpackService.getAllWashPacks();
		
		return new ResponseEntity<List<WashPacks>>(allPacks, HttpStatus.OK);
		
	}
	
	@PostMapping("/addWashPacks")
	public ResponseEntity<WashPacks> addWashPacks(@Valid @RequestBody WashPacks washPacks) {
		
		washpackService.addWashPacks(washPacks);
		
		return new ResponseEntity<WashPacks>(washPacks, HttpStatus.OK);
	}
	
	@PutMapping("/updateWashPacks")
	public WashPacks updateWashPacks( @RequestBody WashPacks washPacks) {
		return washpackService.updateWashPacks(washPacks); 
	}

	@DeleteMapping("/deleteWashPacks/{washpackId}")
	public boolean deleteWashPacks(@Valid @PathVariable String washpackId) throws WashPackNotFoundException {
		return washpackService.deleteById(washpackId);
	}
	
//	Method to get washpack by id
	@GetMapping("{packId}")
	public ResponseEntity<WashPacks> getCarById(@Valid @PathVariable("packId") String packId) {
		return new ResponseEntity<WashPacks>(washpackService.findWashpacksById(packId),HttpStatus.OK);
	}



}
