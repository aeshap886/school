package com.exampl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByUsername(String username);
}
