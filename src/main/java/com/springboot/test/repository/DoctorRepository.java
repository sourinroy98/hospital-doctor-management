package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
