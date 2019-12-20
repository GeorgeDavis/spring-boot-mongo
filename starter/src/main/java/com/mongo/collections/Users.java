package com.mongo.collections;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class Users {
	
	// collections should hold data access layers
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Id
	private ObjectId id;
	private String name;
	private String address;
	private Double salary;
	
	public Users(String name, String address, Double salary) {
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

}
