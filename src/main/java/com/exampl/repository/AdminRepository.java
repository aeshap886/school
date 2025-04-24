package com.exampl.repository;
import entity.Admin;
import entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Long> {
	  Admin findByUsername(String username);

	}

