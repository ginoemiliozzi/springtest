package com.gpl.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.backendninja.constant.ViewConstant;
import com.gpl.backendninja.entity.Contact;
import com.gpl.backendninja.model.ContactModel;
import com.gpl.backendninja.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	
	@GetMapping("cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	@PostMapping("addcontact")
	public String addContact(Model model,
			@ModelAttribute(name="contactModel") ContactModel contactModel) {
		if(contactService.addContact(contactModel)!= null) {
			model.addAttribute("result",1);
		}else {
			model.addAttribute("result",0);
		}
		return "redirect:/contacts/showcontacts";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/contactform")
	public String redirectContactForm(@RequestParam(name="id",defaultValue="0", required=false) int id, Model model) {
		ContactModel contactModel = new ContactModel();
		if(id != 0) {
			contactModel = contactService.findContactModelById(id);
		}				
		model.addAttribute("contactModel",contactModel);
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username",user.getUsername());		
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@GetMapping("removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}
	
}
