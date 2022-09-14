package com.java.dao;

import java.util.List;

import com.java.model.Contact;

public interface ContactDao {

	public int save(Contact contact);

	public int update(Contact contact);

	public int delete(Integer id);

	public Contact get(Integer id);

	public List<Contact> getList();
}
