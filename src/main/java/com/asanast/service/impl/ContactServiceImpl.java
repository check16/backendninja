package com.asanast.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.asanast.component.ContactConverter;
import com.asanast.entity.Contact;
import com.asanast.model.ContactModel;
import com.asanast.repository.ContactRepository;
import com.asanast.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		return contactConverter.convertContactToContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		}
		return contactsModel;
	}

}
