package com.example.demo.dao;

import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {
	 public Employee findById(Integer Id);
	 @Query(value= "select * from employee where city=?" , nativeQuery=true )
		public List<Employee> findByCity(String city);
		
		@Query(value= "select * from employee where name=?" , nativeQuery=true )
		public List<Employee> findByName(String name);

	
	 
}
