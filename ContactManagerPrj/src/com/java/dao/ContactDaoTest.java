/*package com.java.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.java.model.Contact;

public class ContactDaoTest {

	private DriverManagerDataSource ds;
	private ContactDao dao;

	@Before
	public void init() {
		ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
		ds.setUsername("root");
		ds.setPassword("root");

		dao = new ContactDaoImpl();
		dao.
	}

	@Test
	public void testSave() {

		Contact c = new Contact();
		c.setName("a");
		c.setEmail("a@gamil.com");
		c.setAddress("a");
		c.setPhone("09");

		int result = dao.save(c);
		assertTrue(result > 0);
	}

	@Test
	public void testUpdate() {
		Contact c = new Contact();
		c.setId(2);
		c.setName("bb");
		c.setEmail("b@gamil.com");
		c.setAddress("b");
		c.setPhone("09");
		int result = dao.update(c);
		assertTrue(result > 0);
	}

	@Test
	public void testDelete() {
		int result = dao.delete(2);
		assertTrue(result>0);
	}

	@Test
	public void testGet() {
		Contact c = dao.get(1);
		assertNotNull(c);
	}

	@Test
	public void testGetList() {
		List<Contact> c = dao.getList();
		assertTrue(c.size() > 0);
	}

}
*/