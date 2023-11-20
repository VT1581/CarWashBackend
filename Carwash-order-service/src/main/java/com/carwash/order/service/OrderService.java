package com.carwash.order.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.order.Exception.OrderNotFoundException;
import com.carwash.order.model.OrderDetails;
import com.carwash.order.repository.Orderrepo;


@Service
public class OrderService {
	
	@Autowired
	Orderrepo orderrepo;
	
	
	public OrderDetails saveOrder(OrderDetails orderDetails) {
		orderrepo.save(orderDetails);
		return orderDetails;
	}
	
	public OrderDetails updateOrder(OrderDetails orderDetails){
		orderrepo.save(orderDetails);
		return orderDetails;
	}
	
	
	public List<OrderDetails> getAllOrderDetails(){
		List<OrderDetails> li=orderrepo.findAll();
		return li;
	}
	
	public OrderDetails getOrderById(String orderId) throws OrderNotFoundException{
		OrderDetails details= orderrepo.findByOrderId(orderId);
		if(details!=null) {
			return details;
		}
		throw new OrderNotFoundException("There is no order found by given id");
	}
	
	public boolean delateById(String orderId) throws OrderNotFoundException{
		Optional<OrderDetails> details= orderrepo.findById(orderId);
		if(details.isPresent()) {
			orderrepo.delete(details.get());
			return true;
		}
		throw new OrderNotFoundException("There is no order found by given by id");
	}
	

	
	public OrderDetails findOrdersById(String packId) {
		return orderrepo.findById(packId).orElse(null);
	}

	public OrderDetails findOrdersByUserName(String username) {
		// TODO Auto-generated method stub
		List<OrderDetails> l=orderrepo.findByUserName(username);
		OrderDetails or=null;
		for(OrderDetails o:l) {
			if(o.getPaymentStatus().equals("pending")) {
				or=o;
				break;
			}
		}
		return or;
	}
	
	public List<OrderDetails> getOrderByname(String username){
		return orderrepo.findByUserName(username);
	}
	
//	public List<OrderDetails> getOrdersByStatus(String status) throws OrderNotFoundException{
//	List<OrderDetails> li=orderrepo.findByStatus(status);
//	if(li.size()!=0) {
//		return li;
//	}
//	throw new OrderNotFoundException("There is no order found by given status");
//}

//	public List<OrderDetails> getOrderByStatusAndWasherName(String washername,String status){
//	return orderrepo.findByStatusAndWasherName(washername,status);
//}
	
	
}
