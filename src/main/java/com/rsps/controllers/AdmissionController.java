package com.rsps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rsps.models.Admission;
import com.rsps.services.AdmissionService;



@RestController
@RequestMapping("/api/admission")

@CrossOrigin(origins = {
	    "http://localhost:3000",
	    "https://superb-cascaron-798d76.netlify.app"})
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;



    // SAVE ADMISSION
    @PostMapping
    public Admission saveAdmission(
            @RequestBody Admission admission
    ) {

        return admissionService.saveAdmission(admission);
    }



    // GET ALL ADMISSIONS
    @GetMapping
    public List<Admission> getAllAdmissions(){

        return admissionService.getAllAdmissions();
    }



    // DELETE ADMISSION
    @DeleteMapping("/{id}")
    public String deleteAdmission(
            @PathVariable Long id
    ) {

        admissionService.deleteAdmission(id);

        return "Admission Deleted Successfully";
    }
}