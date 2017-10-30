package com.prokarma.pkmst.controller;

import io.swagger.annotations.ApiParam;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.pkmst.model.Car;
import com.prokarma.pkmst.model.CarRepository;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-26T02:45:52.152Z")

@Controller
public class CarApiController implements CarApi {
    private final ObjectMapper objectMapper;
    @Autowired
    CarRepository carRepository;
@Autowired
    public CarApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

	public ResponseEntity<List<Car>> allCars(@RequestHeader(value = "Accept", required = false) String accept) throws Exception {
	    // do some magic!
	
	    if (accept != null && accept.contains("application/xml")) {
	        return new ResponseEntity<List<Car>>(carRepository.findAll(), HttpStatus.OK);
	    }
	
	
	    if (accept != null && accept.contains("application/json")) {
	        return new ResponseEntity<List<Car>>(carRepository.findAll(), HttpStatus.OK);
	    }
	
	    return new ResponseEntity<List<Car>>(carRepository.findAll(),HttpStatus.OK);
	}

    public ResponseEntity<Void> createCar(@ApiParam(value = "Created car object" ,required=true )   @RequestBody Car body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!
    	carRepository.save(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> createCarsWithArrayInput(@ApiParam(value = "List of car object" ,required=true )   @RequestBody List<Car> body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!
    	for (Car car : body) {
    		carRepository.save(car);
		}
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteCar(@ApiParam(value = "The car vinNumber that needs to be deleted",required=true ) @PathVariable("vinNumber") String vinNumber,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!
    	carRepository.delete(this.carRepository.findByVinNumber(vinNumber).getId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Car> getCarByVinNumber(@ApiParam(value = "The vinNumber that needs to be fetched. Use v101 for testing. ",required=true ) @PathVariable("vinNumber") String vinNumber,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!
        if (accept != null && accept.contains("application/xml")) {
            return new ResponseEntity<>(this.carRepository.findByVinNumber(vinNumber), HttpStatus.OK);
        }


        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(this.carRepository.findByVinNumber(vinNumber), HttpStatus.OK);
        }

        return new ResponseEntity<>(this.carRepository.findByVinNumber(vinNumber),HttpStatus.OK);
    }

    public ResponseEntity<Void> updateCar(@ApiParam(value = "vinNumber that need to be updated",required=true ) @PathVariable("vinNumber") String vinNumber,
        @ApiParam(value = "Updated car object" ,required=true )   @RequestBody Car body,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
    	carRepository.save(body);
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
