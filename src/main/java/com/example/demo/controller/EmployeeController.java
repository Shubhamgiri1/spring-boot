package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger logger =LoggerFactory.getLogger(EmployeeController.class);
@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		//logger.info("in save method");
		Employee emp = employeeService.saveEmployee(employee);

		return ResponseEntity.ok().body(emp);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Integer id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
	return ResponseEntity.ok().body(emp);
}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") Integer id)throws Exception {
	employeeService.deleteEmployee(id);
	}
	

	@GetMapping("/city/{city}")
		public ResponseEntity<List<Employee>> getListByCity(@PathVariable("city") String city){
			
			List<Employee> list=employeeService.getListByCity(city);
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping("/name/{name}")
		public ResponseEntity<List<Employee>> getListByName(@PathVariable("name") String name){
			
			List<Employee> list=employeeService.getListByName(name);
			return ResponseEntity.ok().body(list);
		}
		@PutMapping("/update/{id}")
		public Employee update (@RequestBody Employee employee) {
			employeeService.update(employee);
			return employee;
		}

}