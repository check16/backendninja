package com.asanast.service;

import java.util.List;

import com.asanast.model.ContactModel;

public interface ContactService {
	
	public ContactModel addContact(ContactModel contactModel);
	
	public List<ContactModel> listAllContacts();

}
