package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.dao.ContactDao;
import com.java.model.Contact;

@Controller
public class ContactController {
	@Autowired
	private ContactDao contactDao;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(Model model) {
		List<Contact> cList = contactDao.getList();
		model.addAttribute("contactList", cList);
		return "index";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "createOrupdate";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContact(@Valid @ModelAttribute Contact c, BindingResult br) {
		if(br.hasErrors()){
			return "createOrupdate";
		}
		if (c.getId() == null) {
			contactDao.save(c);
		} else {
			contactDao.update(c);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editContact(@PathVariable int id, Model model) {
		Contact contact = contactDao.get(id);
		model.addAttribute("contact", contact);
		return "createOrupdate";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String newContact(@PathVariable int id) {
		contactDao.delete(id);
		return "redirect:/";
	}
}
