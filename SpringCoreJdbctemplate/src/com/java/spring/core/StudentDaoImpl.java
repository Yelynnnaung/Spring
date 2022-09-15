package com.java.spring.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> getStudents() {

		String sql = "SELECT * FROM student";
		RowMapper<Student> rm = new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int roll) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				return student;
			}
		};
		return jdbcTemplate.query(sql, rm);
	}

	@Override
	public Student getStudentById(Integer id) {

		String sql = "SELECT * FROM student WHERE id=" + id;
		ResultSetExtractor<Student> rse = new ResultSetExtractor<Student>() {
			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Student s = new Student();
					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setAge(rs.getInt(3));
					return s;
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, rse);
	}

	@Override
	public int addNewStudent(Student s) {
		String sql = "INSERT INTO student(name,age) values(?,?)";
		return jdbcTemplate.update(sql, s.getName(), s.getAge());
	}

	@Override
	public int updateStudent(Student s) {
		String sql = "UPDATE student SET name=?,age=? WHERE id=?";
		return jdbcTemplate.update(sql, s.getName(), s.getAge(), s.getId());
	}

	@Override
	public int deleteStudentById(Integer id) {
		String sql = "DELETE FROM student WHERE id=?";
		return jdbcTemplate.update(sql, id);
	}

}
