package com.carwash.order.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.order.model.OrderDetails;

@Repository
public interface Orderrepo extends MongoRepository<OrderDetails,String>{
	public OrderDetails findByOrderId(String orderId);

	//public OrderDetails findByUserName(String username);
	
	public List<OrderDetails> findByUserName(String username);
	
}
