package com.rsps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsps.models.Contact;
import com.rsps.services.ContactService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "https://superb-cascaron-798d76.netlify.app"})
public class ContactController {
	
	  @Autowired
	    private ContactService contactService;

	    // SAVE CONTACT MESSAGE
	    @PostMapping
	    public Contact saveMessage(@RequestBody Contact message) {
	        return contactService.saveMessage(message);
	    }

	 // GET ALL CONTACT MESSAGES
	    @GetMapping
	    public List<Contact> getAllMessages() {
	        return contactService.getAllMessages();
	    }

	    // DELETE MESSAGE
	    @DeleteMapping("/{id}")
	    public String deleteMessage(@PathVariable Long id) {

	        contactService.deleteMessage(id);

	        return "Message Deleted Successfully";
	    }
}
