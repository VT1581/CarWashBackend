package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Promocode;
import com.example.demo.model.WashPack;
import com.example.demo.repository.WashPackRepo;
import com.example.demo.restClients.PromocodeClient;



@RestController
@CrossOrigin("http://localhost:4200")
public class WashPackController {
	

	@Autowired
	PromocodeClient promocodeClient;
	
	@Autowired
	WashPackRepo washpackrepo;
	
	@RequestMapping(value = "/washpack", method = RequestMethod.POST)

		public WashPack create(@RequestBody WashPack washpack) {

			System.out.println(washpack.getPromocodeCode());

			Promocode promocode = promocodeClient.getPromocode(washpack.getPromocodeCode());

			BigDecimal discountPercentage = promocode.getDiscount();

		    BigDecimal washpackPrice = washpack.getWashpackPrice();

		    BigDecimal discountAmount = washpackPrice.multiply(discountPercentage.divide(BigDecimal.valueOf(100)));
	 
		    BigDecimal discountedPrice = washpackPrice.subtract(discountAmount);
	 
		    washpack.setWashpackPrice(discountedPrice);

		    return washpackrepo.save(washpack);


		
		
		
		
	}

}
