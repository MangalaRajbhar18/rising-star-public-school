package com.rsps.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsps.models.Pamphlet;
import com.rsps.repositories.PamphletRepository;

@RestController
@RequestMapping("/api/pamphlets")
@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "https://superb-cascaron-798d76.netlify.app"})
public class PamphletController {
	
	 private final PamphletRepository pamphletRepository;





	    public PamphletController(
	            PamphletRepository pamphletRepository) {

	        this.pamphletRepository = pamphletRepository;
	    }





	    @GetMapping
	    public List<Pamphlet> getAllPamphlets(){

	        return pamphletRepository.findAll();
	    }





	    @PostMapping
	    public Pamphlet addPamphlet(
	            @RequestBody Pamphlet pamphlet){

	        return pamphletRepository.save(pamphlet);
	    }





	    @DeleteMapping("/{id}")
	    public void deletePamphlet(
	            @PathVariable Long id){

	        pamphletRepository.deleteById(id);
	    }

}
