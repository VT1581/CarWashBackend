package com.carwash.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.carwash.order.model.OrderDetails;
import com.carwash.order.repository.Orderrepo;
@DataMongoTest
public class CarwashOrderRepositoryTestCases {
	
	@Autowired
    private Orderrepo orderRepository;



    @Test
    public void testFindByOrderId() {
        OrderDetails order = new OrderDetails("3","saritha","car washing","success", "test3@gmail.com", new Date(2023-10-15), "BMW",400.0, "ap");
        orderRepository.save(order);
        OrderDetails foundOrder = orderRepository.findByOrderId("3");
        assertNotNull(foundOrder);
        assertEquals("3", foundOrder.getOrderId());
    }

}
