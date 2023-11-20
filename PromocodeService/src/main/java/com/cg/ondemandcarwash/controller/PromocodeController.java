package com.cg.ondemandcarwash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.carwash.order.model.OrderDetails;
import com.cg.ondemandcarwash.model.Promocode;
import com.cg.ondemandcarwash.repository.Promocoderepository;

import jakarta.validation.Valid;
//import com.na.carwash.entity.Washer;



@RestController
@RequestMapping("/promocodeapi")
@CrossOrigin(origins = "http://localhost:4200")
public class PromocodeController {
	
	@Autowired
	Promocoderepository promocoderepository;
	
	//http://localhost:8081/promocodeapi/promocode
	@RequestMapping(value = "/promocode",method = RequestMethod.POST)
	public Promocode create(@Valid @RequestBody Promocode promocode) {
		return promocoderepository.save(promocode);
	}
	
	//localhost:8081/promocodeapi/promocode/ABC123
	@RequestMapping(value= "/promocode/{code}",method = RequestMethod.GET)
	public Promocode getPromocode(@Valid @PathVariable String code) {
		return promocoderepository.findByCode(code);
	}
	
	//localhost:8081/promocodeapi/allpromocodes
	@GetMapping("/allpromocodes")
	public List<Promocode> getAllPromocodes(){
		return promocoderepository.findAll();
	}
	
	//localhost:8081/promocodeapi/deletemapping/
	@DeleteMapping("/deletemapping/{Id}")
	public boolean deletebyId(@Valid @PathVariable String Id) {
		if(promocoderepository.findByCode(Id)!=null) {
		promocoderepository.deleteById(Id);
		return true;
		}
		else {
			return false;
		}
	}
	
}
