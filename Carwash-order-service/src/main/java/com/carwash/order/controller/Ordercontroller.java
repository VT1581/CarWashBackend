package com.carwash.order.controller;

import java.util.Date;
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

import com.carwash.order.Exception.OrderNotFoundException;
import com.carwash.order.model.OrderDetails;
import com.carwash.order.service.OrderService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/orders")
@CrossOrigin("http://localhost:4200")
public class Ordercontroller {
	
	@Autowired
	OrderService orderService;
	
	
	@PostMapping("/addOrder")
	public OrderDetails addOrder(@Valid @RequestBody OrderDetails orderDetails) {
		orderDetails.setDate(new Date());
		orderDetails.setPaymentStatus("pending");
		return orderService.saveOrder(orderDetails);
	}

	
	@GetMapping("/allorders")
	public List<OrderDetails> getAllorders(){
		return orderService.getAllOrderDetails();
	}
	
	@GetMapping("/byname/{userName}")
	public OrderDetails getorder(@PathVariable String userName){
		return orderService.findOrdersByUserName(userName);
	}
	
	@GetMapping("/orderbyname/{userName}")
	public List<OrderDetails> getorders(@PathVariable String userName){
		return orderService.getOrderByname(userName);
	}

	
	@PutMapping("/updatestatus/{orderId}/{status}")
	public OrderDetails updateStatus(@Valid @PathVariable String orderId,@Valid @PathVariable String status) throws OrderNotFoundException {
		OrderDetails order=orderService.getOrderById(orderId);
		return orderService.saveOrder(order);
	}
	
	@PutMapping("/update/{userName}/{status}")
	public OrderDetails updateStatusbyname(@PathVariable String userName,@PathVariable String status) {
		OrderDetails details=orderService.findOrdersByUserName(userName);
		details.setPaymentStatus(status);
		orderService.saveOrder(details);
		
		return details;
	}
	
	@PutMapping("/updateOrder")
	public OrderDetails updateOrder(@Valid @RequestBody OrderDetails orderDetails) {
		return orderService.updateOrder(orderDetails); 
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public boolean delateOrder(@Valid @PathVariable String orderId) throws OrderNotFoundException {
		return orderService.delateById(orderId);
	}
	
	@GetMapping("/order/{Id}")
	public OrderDetails getOrederById(@PathVariable String Id) throws OrderNotFoundException {
		return orderService.getOrderById(Id);
	}

	
//	Method to get washpack by id
	@GetMapping("{orderId}")
	public ResponseEntity<OrderDetails> getCarById(@Valid @PathVariable("packId") String packId) {
		return new ResponseEntity<OrderDetails>(orderService.findOrdersById(packId),HttpStatus.OK);
	}
}
