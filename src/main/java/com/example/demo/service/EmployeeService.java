package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public Optional<Employee> getEmployeeById(Integer Id);
	public void deleteEmployee(Integer id);
	public List<Employee> getListByCity(String city);
    public List<Employee> getListByName(String name);
    public void update (Employee employee);

}
