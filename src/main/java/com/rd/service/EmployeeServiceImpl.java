package com.rd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rd.entity.Employee;
import com.rd.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
       int idVal=empRepo.save(emp).getEmpno();
		return "Employee is saved with the id value ::"+idVal; 
	}

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp=empRepo.findById(no).get();
		return emp;
	}

	@Override
	public String editEmployee(Employee emp) {
	       int idVal=empRepo.save(emp).getEmpno();  //save(-)  method can perform both save /edit operations
			return idVal+" Employee is updated "; 

	}
	
	@Override
	public String deleteEmployee(int no) {
		  empRepo.deleteById(no);
		  return no+" emp no Employee is deleted";
	}

}
