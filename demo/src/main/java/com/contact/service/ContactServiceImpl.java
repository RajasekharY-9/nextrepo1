package com.contact.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	
	
	@Override
	public  Contact saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContacts( ) {
		// TODO Auto-generated method stub
		return	contactRepository.findAll();
		
		
		
	}

	@Override
	public Optional<Contact> getContact(int id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id) ;
	}

	@Override
	public String deleteConatct(int id) {
		// TODO Auto-generated method stub
		 contactRepository.deleteById(id);
		 return "Deleted Successfully";
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		
		
		
		return contactRepository.saveAndFlush(contact);
	}

}
