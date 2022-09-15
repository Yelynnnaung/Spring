package com.java.spring.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcApp {

	public static void main(String[] args) {
		ApplicationContext cx = new ClassPathXmlApplicationContext("Beans.xml");
		StudentDao studentDao = (StudentDaoImpl) cx.getBean("studentDaoImpl");

		// INSERT
		/*
		 * int result = studentDao.addNewStudent(new Student("Aye Aye", 23));
		 * if(result > 0) System.out.println("Successfully Added");
		 */

		// SELECT ALL
		/*
		 * List<Student> studentList = studentDao.getStudents(); for(Student
		 * student : studentList) { System.out.println(student); }
		 */

		// SELECT BY ID
		/*
		 * Student student = studentDao.getStudentById(1);
		 * System.out.println(student);
		 */

		// UPDATE
		/*
		 * Student student = studentDao.getStudentById(1);
		 * student.setName("MG MG AYE"); student.setAge(30); int result =
		 * studentDao.updateStudent(student); if (result > 0)
		 * System.out.println("Successfully Updated");
		 */

		// DELETE BY ID
		
		 int result= studentDao.deleteStudentById(2);
		 if(result>0) System.out.println("Successfully Deleted");
		 
	}

}
