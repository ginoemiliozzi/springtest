package com.gpl.backendninja.service;

import java.util.List;

import com.gpl.backendninja.entity.Contact;
import com.gpl.backendninja.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactModelById(int id);
}
