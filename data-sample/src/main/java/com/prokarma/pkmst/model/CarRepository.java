package com.prokarma.pkmst.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Long> {

	public Car findByVinNumber(@Param("vinNumber") String vinNumber);

}
