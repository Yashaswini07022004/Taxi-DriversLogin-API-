package com.example.TaxiDrivers.Repository;
		
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.TaxiDrivers.Model.DriverExperience;

@Repository
public interface DriverExperienceRepository extends MongoRepository<DriverExperience, String> 
{
	Optional<DriverExperience> findByfullName(String fullName);
}
