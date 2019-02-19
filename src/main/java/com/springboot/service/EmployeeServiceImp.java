package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeRepository;
import com.springboot.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee empFindById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee>result = employeeRepository.findById(theId);
		Employee emp=null;
		if(result.isPresent()) {
			emp=result.get();
		}else {
			throw new RuntimeException("Data not found "+theId);
		}
		return emp;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}


	
}
