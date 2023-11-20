package com.na.pay.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.na.pay.model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment,String>{

	Payment findByName(String string);

}
