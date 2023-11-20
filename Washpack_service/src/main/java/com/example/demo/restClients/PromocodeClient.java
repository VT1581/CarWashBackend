package com.example.demo.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Promocode;


@FeignClient(name="PROMOCODESERVICE",url="http://localhost:8082")
public interface PromocodeClient {
	
	 	@GetMapping("/promocodeapi/promocode/{code}")
	    Promocode getPromocode(@PathVariable("code") String code);
	
	

}
