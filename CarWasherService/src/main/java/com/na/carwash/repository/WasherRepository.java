package com.na.carwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.na.carwash.entity.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer, Integer> {

	
    public Washer findById(int id);
	


}
