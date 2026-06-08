package com.rsps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsps.models.Admin;
import com.rsps.repositories.AdminRepository;
import com.rsps.services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "https://superb-cascaron-798d76.netlify.app"})
public class AdminController {
      
	@Autowired
    private AdminService adminService;
	
	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/login")
	public String login(@RequestBody Admin admin) {

	    System.out.println(admin.getEmail());
	    System.out.println(admin.getPassword());

	    Admin validAdmin = adminService.login(admin);

	    if(validAdmin != null) {
	        return "Login Success";
	    }

	    return "Invalid Email or Password";
	}
	
	@GetMapping("/all")
	public List<Admin> getAllAdmins() {
	    return adminRepository.findAll();
	}
}
