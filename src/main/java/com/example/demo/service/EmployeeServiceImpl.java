package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public Optional<Employee> getEmployeeById(Integer Id) {
		Optional<Employee> employee= Optional.ofNullable(employeeRepository.findById(Id));
		return employee;
	}
	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	@Override
	public List<Employee> getListByCity(String city) {
		List<Employee> list=employeeRepository.findByCity(city);
		return list;
	}

	@Override
	public List<Employee> getListByName(String name) {
		List<Employee> list=employeeRepository.findByName(name);
		return list;
	}
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

		
	}
	
	

