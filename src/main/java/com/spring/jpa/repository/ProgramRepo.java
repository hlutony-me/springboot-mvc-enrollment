package com.spring.jpa.repository;

import com.spring.jpa.model.Program;
import com.spring.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepo extends JpaRepository<Program, Long> {

    List<Program> findAll ();
    
    Program findByProgramName(String programName);
}