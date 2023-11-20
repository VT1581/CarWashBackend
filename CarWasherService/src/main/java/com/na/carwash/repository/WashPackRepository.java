package com.na.carwash.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.na.carwash.entity.WashPacks;

@Repository
public interface WashPackRepository extends MongoRepository<WashPacks, String>{

	


}
