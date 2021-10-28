package com.spring.jpa.repository;

import com.spring.jpa.model.Enrollment;
import com.spring.jpa.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

	List<Enrollment> findAll();

	List<Enrollment> findByCustomerId(Long customerId);

}
