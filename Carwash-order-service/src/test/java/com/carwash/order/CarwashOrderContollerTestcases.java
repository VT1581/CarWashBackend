package com.carwash.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.carwash.order.Exception.OrderNotFoundException;
import com.carwash.order.controller.Ordercontroller;
import com.carwash.order.model.OrderDetails;
import com.carwash.order.repository.Orderrepo;
import com.carwash.order.service.OrderService;

public class CarwashOrderContollerTestcases {

	@InjectMocks
	private Ordercontroller ordercontroller;
	
	@Mock
	private OrderService orderService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	// test cases for controller


	private static OrderDetails details;

	@Test
	public void addOrderTestcase() {
		
		long ph = 99089631;
		OrderDetails details = new OrderDetails("3","saritha","car washing","success", "test3@gmail.com", new Date(2023-10-15), "BMW",400.0, "ap");
		when(orderService.saveOrder(details)).thenReturn(details);
		OrderDetails result = ordercontroller.addOrder(details);
		verify(orderService).saveOrder(details);
		verifyNoMoreInteractions(orderService);
		assertEquals(details, result);
	}
	
	
	@Test
	public void getAllOrderDetailsTestcases() {
		List<OrderDetails> li=ordercontroller.getAllorders();
		assertEquals(0,li.size());
	}

	@Test
	public void updateOrdertestcase() {
		
		
		long ph = 99089631;
		OrderDetails details = new OrderDetails("3","saritha","car washing","success", "test3@gmail.com", new Date(2023-10-15), "BMW",400.0, "ap");
		when(orderService.updateOrder(details)).thenReturn(details);
		OrderDetails result = ordercontroller.updateOrder(details);
		verify(orderService).updateOrder(result);
		verifyNoMoreInteractions(orderService);
		assertEquals(details, result);
		
	}
	
	@Test
	public void delateOrderTestcase() throws OrderNotFoundException {
		
		when(orderService.delateById("123")).thenThrow(new OrderNotFoundException("Order not found: " + "123"));
        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, () -> {
            ordercontroller.delateOrder("123");
        });
        verify(orderService).delateById("123");
        verifyNoMoreInteractions(orderService);

	}
	

	@Test
	public void getCarByIdTest() {

		   String packId = "123";
		   OrderDetails details = new OrderDetails("3", "saritha", "car washing", "success", "test3@gmail.com", new Date(), "BMW", 400.0, "ap");

		   when(orderService.findOrdersById(packId)).thenReturn(details);
		   ResponseEntity<OrderDetails> responseEntity = ordercontroller.getCarById(packId);
		   verify(orderService).findOrdersById(packId);
		   verifyNoMoreInteractions(orderService);
	 
		    // Assert the response status
		    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	 
		    // Assert the response body (OrderDetails)
		    OrderDetails result = responseEntity.getBody();
		    assertEquals(details, result);

	 
		

	}
	
}
