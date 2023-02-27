package com.contact.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/add")
	public String addContact(@RequestBody Contact contact) {
		contactService.saveContact(contact);
		
		return "Contact Saved!!!";
	}
	
	@GetMapping("getAll")
	public List<Contact> getAllContact(  ){
		
	return	contactService.getAllContacts();
		
	}
	
	@GetMapping("getOne/{id}")
	public Optional<Contact> getOneContact(@PathVariable int id)
	{
		return contactService.getContact(id);
	}
	
	@DeleteMapping("del/{id}")
	public String deleteContact(@PathVariable Integer id) {
		
	return	contactService.deleteConatct(id);
		
	}
	
	@PutMapping("update")
	public Contact updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}
	
}
