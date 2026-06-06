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

import com.rsps.models.Gallery;
import com.rsps.services.GalleryService;

@RestController

@RequestMapping("/api/gallery")

@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "https://superb-cascaron-798d76.netlify.app"})

public class GalleryController {

    @Autowired
    private GalleryService galleryService;


// GET ALL

    @GetMapping
    public List<Gallery> getGallery() {

        return galleryService.getAllImages();
    }

// ADD IMAGE

    @PostMapping
    public Gallery addImage(@RequestBody Gallery gallery) {

        return galleryService.addImage(gallery);
    }

// DELETE IMAGE

    @DeleteMapping("/{id}")

    public void deleteImage(@PathVariable Long id) {

        galleryService.deleteImage(id);
    }
}