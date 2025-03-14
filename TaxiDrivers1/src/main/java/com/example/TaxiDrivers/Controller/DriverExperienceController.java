package com.example.TaxiDrivers.Controller;

import com.example.TaxiDrivers.Model.DriverExperience;
import com.example.TaxiDrivers.Service.DriverExperienceService;

import jakarta.validation.Valid;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverExperienceController {

    @Autowired
    private DriverExperienceService service;

    @GetMapping
    public List<DriverExperience> getAllDrivers() {
        return service.getAllDrivers();
    }

    @GetMapping("/byName")
    public ResponseEntity<DriverExperience> getDriverByName(@RequestParam String name) {
        Optional<DriverExperience> driver = service.getDriverByName(name);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DriverExperience> addDriverExperience(@Valid @RequestBody DriverExperience driverExperience) {
        DriverExperience savedExperience = service.addDriverExperience(driverExperience);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExperience);
    }

    @PutMapping("/updateByName")
    public ResponseEntity<DriverExperience> updateDriverExperience(@RequestParam String name, @Valid @RequestBody DriverExperience updatedExperience) {
        Optional<DriverExperience> existingDriver = service.getDriverByName(name);
        
        if (existingDriver.isPresent()) {
            updatedExperience.setId(existingDriver.get().getId());
            DriverExperience updated = service.updateDriverExperience(updatedExperience.getId(), updatedExperience);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteByName")
    public ResponseEntity<Void> deleteDriverExperience(@RequestParam String name) {
        Optional<DriverExperience> existingDriver = service.getDriverByName(name);
        
        if (existingDriver.isPresent()) {
            service.deleteDriverExperience(existingDriver.get().getId());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/uploadAllDocuments")
    public ResponseEntity<String> uploadAllDocuments(
            @RequestParam String name,
            @RequestParam("photoFile") MultipartFile photoFile,
            @RequestParam("licenseFile") MultipartFile licenseFile,
            @RequestParam("insuranceFile") MultipartFile insuranceFile) {
        
        // Check if any of the files are empty
        if (photoFile.isEmpty() || licenseFile.isEmpty() || insuranceFile.isEmpty()) {
            return ResponseEntity.badRequest().body("One or more files are empty. Please upload valid files.");
        }

        try {
            // Retrieve the driver experience by name
            DriverExperience driverExperience = service.getDriverByName(name)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

            // Set the profile photo
            driverExperience.setProfilePhoto(new Binary(photoFile.getBytes()));
            
            // Set the license upload
            driverExperience.setLicenseUpload(new Binary(licenseFile.getBytes()));
            
            // Set the insurance document
            driverExperience.setInsuranceDocument(new Binary(insuranceFile.getBytes()));
            
            // Update the driver experience
            service.updateDriverExperience(driverExperience.getId(), driverExperience);

            return ResponseEntity.ok("Files uploaded successfully for driver: " + name);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }

    @PostMapping("/uploadDetails")
    public ResponseEntity<DriverExperience> uploadDriverDetails(@Valid @RequestBody DriverExperience driverExperience) {
        DriverExperience savedDriverExperience = service.addDriverExperience(driverExperience);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDriverExperience);
    }

    @GetMapping("/details")
    public ResponseEntity<DriverExperience> getDriverDetails(@RequestParam String name) {
        Optional<DriverExperience> driver = service.getDriverByName(name);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}