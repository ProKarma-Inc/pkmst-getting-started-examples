package com.prokarma.pkmst.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends MongoRepository<Customer, Long> {

	List<Customer> findByLocation(@Param("location") String e);

}
