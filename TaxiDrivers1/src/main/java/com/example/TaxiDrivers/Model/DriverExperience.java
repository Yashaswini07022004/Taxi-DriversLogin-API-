package com.example.TaxiDrivers.Model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Document(collection = "driver_experience")
public class DriverExperience {

    @Id
    private String id;

    @NotNull(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Phone number is required")
    private String phoneNumber; // WhatsApp-enabled preferred

    @Email(message = "Email should be valid")
    private String emailAddress; // Optional

    private String dateOfBirth;

    @NotNull(message = "Government ID proof is required")
    private String governmentIdProof; // Aadhaar, Passport, or Driving License

    private String currentCity;

    private String currentState;

    private Binary driverProfilePicture; // Store the driver profile picture as binary data

    @NotNull(message = "Vehicle type is required")
    private String vehicleType; // Sedan, SUV, Hatchback, etc.

    private String carBrandAndModel; // e.g., Toyota Innova Crysta, Maruti Swift Dzire

    private String yearOfManufacture; // To assess vehicle condition and comfort level

    private String vehicleColor;

    private String vehicleRegistrationNumber; // RC Copy Upload

    private String vehiclePermitType; // Local City, Intercity, State/Interstate

    private Binary insuranceDocument; // Store insurance document as binary data

    private List<String> serviceOfferings; // Airport Transfers, Intercity Travel, etc.

    private String yearOfExperience; // Less than 1, 1-3 years, 3-5 years, 5+ years

    private List<String> previousRideHailingExperience; // Uber, Ola, etc.

    private List<String> popularDestinations;

    private List<String> languagesSpoken; // Hindi, English, etc.

    private String regionalLanguages;

    private boolean policeVerificationStatus;

    private String vehicleCondition;

    private List<Binary> vehiclePhotos; // Store vehicle photos as binary data

    private boolean acAvailability;

    private String smokingPolicy;

    private boolean petFriendly;

    private Binary licenseUpload; // Store license upload as binary data

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGovernmentIdProof() {
        return governmentIdProof;
    }

    public void setGovernmentIdProof(String governmentIdProof) {
        this.governmentIdProof = governmentIdProof;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Binary getDriverProfilePicture() {
        return driverProfilePicture;
    }

    public void setDriverProfilePicture(Binary driverProfilePicture) {
        this.driverProfilePicture = driverProfilePicture;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCarBrandAndModel() {
        return carBrandAndModel;
    }

    public void setCarBrandAndModel(String carBrandAndModel) {
        this.carBrandAndModel = carBrandAndModel;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getVehiclePermitType() {
        return vehiclePermitType;
    }

    public void setVehiclePermitType(String vehiclePermitType) {
        this.vehiclePermitType = vehiclePermitType;
    }

    public Binary getInsuranceDocument() {
        return insuranceDocument;
    }

    public void setInsuranceDocument(Binary insuranceDocument) {
        this.insuranceDocument = insuranceDocument;
    }

    public List<String> getServiceOfferings() {
        return serviceOfferings;
    }

    public void setServiceOfferings(List<String> serviceOfferings) {
        this.serviceOfferings = serviceOfferings;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public List<String> getPreviousRideHailingExperience() {
        return previousRideHailingExperience;
    }

    public void setPreviousRideHailingExperience(List<String> previousRideHailingExperience) {
        this.previousRideHailingExperience = previousRideHailingExperience;
    }

    public List<String> getPopularDestinations() {
        return popularDestinations;
    }

    public void setPopularDestinations(List<String> popularDestinations) {
        this.popularDestinations = popularDestinations;
    }

    public List<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public String getRegionalLanguages() {
        return regionalLanguages;
    }

    public void setRegionalLanguages(String regionalLanguages) {
        this.regionalLanguages = regionalLanguages;
    }

    public boolean isPoliceVerificationStatus() {
        return policeVerificationStatus;
    }

    public void setPoliceVerificationStatus(boolean policeVerificationStatus) {
        this.policeVerificationStatus = policeVerificationStatus;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(String vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public List<Binary> getVehiclePhotos() {
        return vehiclePhotos;
    }

    public void setVehiclePhotos(List<Binary> vehiclePhotos) {
        this.vehiclePhotos = vehiclePhotos;
    }

    public boolean isAcAvailability() {
        return acAvailability;
    }

    public void setAcAvailability(boolean acAvailability) {
        this.acAvailability = acAvailability;
    }

    public String getSmokingPolicy() {
        return smokingPolicy;
    }

    public void setSmokingPolicy(String smokingPolicy) {
        this.smokingPolicy = smokingPolicy;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public Binary getLicenseUpload() {
        return licenseUpload;
    }

    public void setLicenseUpload(Binary licenseUpload) {
        this.licenseUpload = licenseUpload;
    }

    public void setProfilePhoto(Binary binary) {
        this.driverProfilePicture = binary; // Assign the provided binary data to the driverProfilePicture field
    }
}