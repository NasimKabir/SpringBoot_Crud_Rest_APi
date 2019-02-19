package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
public List<Employee> getEmployee();
	
	public Employee empFindById(int theId);
	
	public void addEmployee(Employee theEmployee);
	
	public void deleteEmployee(int theId);
}
