package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.java.model.Contact;

public class ContactDaoImpl implements ContactDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO Contact (name,email,address,phone) values (?,?,?,?)";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone());

	}

	@Override
	public int update(Contact c) {
		String sql = "UPDATE Contact SET name =?,email=?,address=?,phone=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(),c.getAddress(),c.getPhone(),c.getId());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Contact WHERE contact_id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM Contact WHERE contact_id =" + id;

		ResultSetExtractor<Contact> res = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if (rs.next()) {
					Contact c = new Contact();
					c.setId(rs.getInt("contact_id"));
					c.setName(rs.getString("name"));
					c.setEmail(rs.getString("email"));
					c.setAddress(rs.getString("address"));
					c.setPhone(rs.getString("phone"));
					return c;
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, res);
	}

	@Override
	public List<Contact> getList() {
		String sql = "SELECT * FROM Contact";
		RowMapper<Contact> rm = new RowMapper<Contact>() {
			
			@Override
			public Contact mapRow(ResultSet rs, int roll) throws SQLException {
				Contact c = new Contact();
				c.setId(rs.getInt("contact_id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
				return c;
			}
		};
		return jdbcTemplate.query(sql, rm);
	}

}
