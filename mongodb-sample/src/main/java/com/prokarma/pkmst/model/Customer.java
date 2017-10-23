package com.prokarma.pkmst.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	@Id	
	private Long id;

	private String name;

	private String location;
	
	Customer() {
	}

	public Customer(Long id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + location;
	}

}
