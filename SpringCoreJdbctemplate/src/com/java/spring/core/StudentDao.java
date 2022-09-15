package com.java.spring.core;

import java.util.List;

public interface StudentDao {

	public List<Student> getStudents();

	public int addNewStudent(Student student);

	public int updateStudent(Student student);

	public Student getStudentById(Integer id);

	public int deleteStudentById(Integer id);

}
