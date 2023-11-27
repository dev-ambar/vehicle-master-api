package com.gtmsoftware.fleetwise.vehiclemaster.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "vehicleMaster")
public class Vehicle {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
