package com.java.dao;

import java.util.List;

import com.java.bean.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployeeList(); 
	
	public int saveEmployee(Employee e);

	public int updateEmployee(Employee e);

	public int deleteEmployee(Employee e);
}
