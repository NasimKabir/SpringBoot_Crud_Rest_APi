package com.springboot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> allempInfo() {
		return employeeService.getEmployee();
	}

	@GetMapping("/employee/{id}")
	public Employee getemp(@PathVariable int id) {
		Employee emp = employeeService.empFindById(id);
		return emp;
	}

	@PutMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
		return emp;
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmp(@PathVariable int id) {
		Employee emp = employeeService.empFindById(id);
		employeeService.deleteEmployee(id);
		return "Deleted id is " + id;
	}
}
