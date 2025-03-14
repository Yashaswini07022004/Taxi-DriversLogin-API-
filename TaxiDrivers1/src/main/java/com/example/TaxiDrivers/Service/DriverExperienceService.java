package com.example.TaxiDrivers.Service;

import com.example.TaxiDrivers.Model.DriverExperience;
import com.example.TaxiDrivers.Repository.DriverExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverExperienceService {

    @Autowired
    private DriverExperienceRepository repository;

    public List<DriverExperience> getAllDrivers() 
    {
        return repository.findAll();
    }

    public Optional<DriverExperience> getDriverById(String id) 
    {
        return repository.findById(id);
    }

    public Optional<DriverExperience> getDriverByName(String fullName) 
    {
        return repository.findByfullName(fullName); // Call the repository method to find by name
    }

    public DriverExperience addDriverExperience(DriverExperience driverExperience) 
    {
        return repository.save(driverExperience);
    }

    public DriverExperience updateDriverExperience(String id, DriverExperience updatedExperience) 
    {
        // You may want to check if the driver exists before updating
        if (repository.existsById(id)) 
        {
            updatedExperience.setId(id); // Ensure the ID is set for the update
            return repository.save(updatedExperience);
        }
        return null; // Or throw an exception
    }

    public void deleteDriverExperience(String id) 
    {
        repository.deleteById(id);
    }
}