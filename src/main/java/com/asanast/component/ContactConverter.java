package com.asanast.component;

import org.springframework.stereotype.Component;

import com.asanast.entity.Contact;
import com.asanast.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public Contact convertContactModelToContact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setId(contactModel.getId());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		
		return contact;
	}
	
	public ContactModel convertContactToContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contactModel.getCity());
		contactModel.setFirstname(contactModel.getFirstname());
		contactModel.setId(contactModel.getId());
		contactModel.setLastname(contactModel.getLastname());
		contactModel.setTelephone(contactModel.getTelephone());
		
		return contactModel;
	}

}
