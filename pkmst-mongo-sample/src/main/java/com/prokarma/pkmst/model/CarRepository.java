package com.prokarma.pkmst.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends MongoRepository<Car, Long> {

	public Car findByVinNumber(@Param("vinNumber") String vinNumber);

}
