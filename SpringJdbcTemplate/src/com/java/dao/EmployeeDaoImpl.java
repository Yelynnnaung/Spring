package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.java.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> getEmployeeList() {
		String selectQuery = "select * from employee";
		return jdbcTemplate.query(selectQuery,new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getFloat(3));
				return employee;
			}			
		});
	}

	@Override
	public int saveEmployee(Employee e) {
		String insertQuery = "insert into employee values(" + e.getId() + ",'" + e.getName() + "'," + e.getSalary()
				+ ")";
		return jdbcTemplate.update(insertQuery);
	}

	@Override
	public int updateEmployee(Employee e) {
		String updateQuery = "update employee set name = '" + e.getName() + "',salary = " + e.getSalary()
				+ " where id =" + e.getId();
		return jdbcTemplate.update(updateQuery);
	}

	@Override
	public int deleteEmployee(Employee e) {
		String deleteQuery = "delete employee where id =" + e.getId();
		return jdbcTemplate.update(deleteQuery);
	}

}
