package com.gtmsoftware.fleetwise.vehiclemaster.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "vehicle_master",schema = "fleetwise_schema")
@Setter
@Getter
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String registrationNo;
    @Column(name = "chassisNo")
    private String chassisNo;
    @Column
    private String engineNo;
    @Column
    private String currentOwnerName;
    @Column
    private String mobileNo;
    @Column
    private String vinNo;
    @Column
    private String fitnessValidUpTo;
    @Column
    private String modelName;
    @Column
    private String makerName;
    @Column
    private String vehicleType;
    @Column
    private String fuelType;
    @Column
    private String registrationDate;
    @Column
    private String taxValidUpTo;
    @Column
    private String emissionNorm;
    @Column
    private String financier;
    @Column
    private String isActive;
    @Column
    private Timestamp createAt;
    @Column
    private Timestamp updatedAt;
    @Column
    private String createdBy;
    @Column
    private String updatedBy;

}
