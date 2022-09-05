package com.java.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bean.Employee;
import com.java.dao.EmployeeDao;

public class TestApplication {
	public static void main(String[] args) {

		ApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) cx.getBean("employeeDao");
		/* int status = employeeDao.saveEmployee(new Employee(1, "Mg Mg", 1000000)); */
		//System.out.println(status);
		List<Employee> ls = employeeDao.getEmployeeList();
		System.out.println(ls.size());
		
	}
}
