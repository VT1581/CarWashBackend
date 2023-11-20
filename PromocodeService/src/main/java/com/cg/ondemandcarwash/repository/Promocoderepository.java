package com.cg.ondemandcarwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ondemandcarwash.model.Promocode;

public interface Promocoderepository  extends MongoRepository<Promocode, String>{

	Promocode findByCode(String code);

}


