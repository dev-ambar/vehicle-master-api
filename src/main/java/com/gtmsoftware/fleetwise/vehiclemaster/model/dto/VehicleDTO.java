package com.gtmsoftware.fleetwise.vehiclemaster.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
public class VehicleDTO {

    private Long id;
    
    private String registrationNo;
    
    private String chassisNo;
    
    private String engineNo;
    
    private String currentOwnerName;
    
    private String mobileNo;
    
    private String vinNo;
    
    private String fitnessValidUpTo;
    
    private String modelName;
    
    private String makerName;
    
    private String vehicleType;
    
    private String fuelType;
    
    private String registrationDate;
    
    private String taxValidUpTo;
    
    private String emissionNorm;
    
    private String financier;
    
    private String isActive;
    
    private Timestamp createAT;
    
    private Timestamp updatedAT;
    
    private String createdBy;
    
    private String updatedBy;



}
