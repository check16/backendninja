package com.asanast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asanast.constant.ViewConstant;
import com.asanast.model.ContactModel;
import com.asanast.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@GetMapping("/contactform")
	public String redirectContactForm(Model model) {
		model.addAttribute("contactModel", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}

	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.CONTACTS;
	}

	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
		if (contactService.addContact(contactModel) != null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}

		return ViewConstant.CONTACTS;

	}

}
