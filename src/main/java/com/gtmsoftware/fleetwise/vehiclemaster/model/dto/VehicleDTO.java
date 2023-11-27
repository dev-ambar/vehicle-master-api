package com.gtmsoftware.fleetwise.vehiclemaster.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter

public class VehicleDTO {
    private Long id;
    private String rcNumber;
    private String chassisNumber;
    private String engineNumber;
    private String currentOwner;
    private String registerNumber;
    private String vinNumber;
    private String fitnessDate;
    private String model;
    private String make;
    private String gadiType;
    private String fuelType;
    private String manufacturingDate;
    private String emissionType;
    private Boolean isActive;
    private Timestamp timestamp;
    private String createdBy;
    private String updatedBy;



}
