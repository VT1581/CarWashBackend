package com.carwash.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.carwash.order.Exception.OrderNotFoundException;
import com.carwash.order.model.OrderDetails;
import com.carwash.order.repository.Orderrepo;
import com.carwash.order.service.OrderService;

@SpringBootTest
class CarwashOrderServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	//test cases for service
	
	private static OrderDetails details;
	
	@InjectMocks
    private OrderService service;

    @Mock
    private Orderrepo orderrepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	
	@Test
	public void saveOrderTestcase() {
		
		long ph=99089631;
		OrderDetails details = new OrderDetails("3","saritha","car washing","success", "test3@gmail.com", new Date(2023-10-15), "BMW",400.0, "ap");
		assertEquals(details,service.saveOrder(details));
	}
	
	@Test
	public void updateorderTestcase() {
		
		long ph=99089631;
		OrderDetails details = new OrderDetails("3","saritha","car washing","success", "test3@gmail.com", new Date(2023-10-15), "BMW",400.0, "ap");
		assertEquals(details,service.saveOrder(details));
		}
	
	
	@Test
	public void getAllOrderDetailsTestcases() {
		List<OrderDetails> li=service.getAllOrderDetails();
		assertEquals(0,li.size());
	}
	
	@Test
	public void getOrderByIdTestcase() throws OrderNotFoundException {
		assertThrows(OrderNotFoundException.class,()->service.getOrderById("123"));
	}
	
	@Test
	public void delateByIdTestcase() throws OrderNotFoundException{
		assertThrows(OrderNotFoundException.class,()->service.delateById("123"));
	}
	
	@Test
	public void findOrdersByIdTest() {
	    String packId = "123";
 
	    
	    OrderDetails details = new OrderDetails("3", "saritha", "car washing", "success", "test3@gmail.com", new Date(), "BMW", 400.0, "ap");
 
	    when(orderrepo.findById(packId)).thenReturn(Optional.of(details));
	    OrderDetails result = service.findOrdersById(packId);
	    verify(orderrepo).findById(packId);
	    verifyNoMoreInteractions(orderrepo);
	    assertNotNull(result);
	    assertEquals(details, result);
	}

	
	
}
