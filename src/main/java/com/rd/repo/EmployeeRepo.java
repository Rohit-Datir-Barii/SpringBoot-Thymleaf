package com.rd.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rd.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Serializable> {

}
