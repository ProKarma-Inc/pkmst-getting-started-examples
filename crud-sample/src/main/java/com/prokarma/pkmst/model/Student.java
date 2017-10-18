package com.prokarma.pkmst.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String email;

	Student() {
	}

	public Student(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		return "Student {" + "id=" + id + ", name='" + name + '\'' + ", email='" + email
				+ '\'' + '}';
	}

}
