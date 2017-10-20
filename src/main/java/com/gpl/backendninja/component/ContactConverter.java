package com.gpl.backendninja.component;

import org.springframework.stereotype.Component;

import com.gpl.backendninja.entity.Contact;
import com.gpl.backendninja.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public Contact convertContactModel2Contact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setId(contactModel.getId());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}
	
	public ContactModel convertContact2ContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setId(contact.getId());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}
}
