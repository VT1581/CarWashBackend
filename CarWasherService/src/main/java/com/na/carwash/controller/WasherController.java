package com.na.carwash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.na.carwash.entity.Washer;
import com.na.carwash.repository.WasherRepository;
import com.na.carwash.service.WasherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carwasher")
@CrossOrigin("http://localhost:4200")
public class WasherController {

	@Autowired
	private WasherService washerService;
	
	@Autowired
	private WasherRepository washerRepository;
	
	@PostMapping("/add-washer")
	public ResponseEntity<Washer> addWasher(@Valid @RequestBody Washer washer) {
		
		washerService.addNewWasher(washer);
		return new ResponseEntity<Washer>(washer, HttpStatus.OK);	
	}
	
	@GetMapping("/get-washer/{name}")
	public ResponseEntity<Washer> getWasherByName(@Valid @PathVariable String name){
		
		Washer washer = washerService.findByName(name);
		return new ResponseEntity<Washer>(washer, HttpStatus.OK);
	}
	
	@GetMapping("/get-all-washer")
	public ResponseEntity<List<Washer>> getAllWashers() {
		
		List<Washer> allWashers = washerService.getAllWashers();
		return new ResponseEntity<List<Washer>>(allWashers, HttpStatus.OK);
		
		
	}
	
	@PutMapping("/update-profile/{id}")
	public ResponseEntity<Washer> updateProfile(@Valid @PathVariable int id,
			@RequestBody Washer washer) {
		Washer updatedWasher = washerService.updateProfile(washer, id);

        if (updatedWasher != null) {
            return ResponseEntity.ok(updatedWasher);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
