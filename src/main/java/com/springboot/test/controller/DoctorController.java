package com.springboot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.entity.Doctor;
import com.springboot.test.exception.ResourceAlreadyExistException;
import com.springboot.test.exception.ResourceNotFoundException;
import com.springboot.test.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/getdoctors")
	public List<Doctor> getDoctors()
	{
		List<Doctor> doctors = doctorService.getDoctors();
		if(doctors.size() <= 0)
		{
			throw new ResourceNotFoundException("There is no doctors data at this time please add a data");
		}
		
		return doctors;
	}
	
	@GetMapping("/getdoctorbyid/{id}")
	public Doctor getDoctorById(@PathVariable int id)
	{
		Doctor doctor = doctorService.getDoctorById(id);
		
		if(doctor == null)
		{
			throw new ResourceNotFoundException("no data present");
		}
		
		return doctor;
	}
	
	@PostMapping("/adddoctor")
	public void addDoctor(@RequestBody Doctor doctor)
	{
		Doctor doctor1 = doctorService.getDoctorById(doctor.getId());
		
		if(doctor1 != null)
		{
			throw new ResourceAlreadyExistException("Doctor already exists in the database");
		}
		
		doctorService.addDoctor(doctor);
	}
	
	@PutMapping("/updatedoctor/{salary}")
	public Doctor updateDoctor(@RequestBody Doctor doctor,@PathVariable double salary)
	{
		return doctorService.updateDoctor(doctor);
	}
}

