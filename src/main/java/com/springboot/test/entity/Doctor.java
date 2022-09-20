package com.springboot.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctordata")
public class Doctor implements Comparable<Doctor>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double salary;
	private String specialist;
	
	public Doctor() {
		super();
	}

	public Doctor(int id, String name, double salary, String specialist) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.specialist = specialist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", salary=" + salary + ", specialist=" + specialist + "]";
	}

	@Override
	public int compareTo(Doctor d) {
		
		if(this.salary != d.salary)
		{
			if(this.salary > d.salary)
				return -1;
			else
				return 1;
		}
		
		else {
			return this.name.compareTo(d.name);
		}
	}
	
	

}
