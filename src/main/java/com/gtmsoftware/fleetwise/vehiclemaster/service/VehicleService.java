package com.gtmsoftware.fleetwise.vehiclemaster.service;

import com.gtmsoftware.fleetwise.vehiclemaster.model.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

     List<Vehicle> getAllVehicles();
     public Optional<Vehicle> getVehicleById(Long id);
     public Vehicle saveOrUpdateVehicle(Vehicle vehicle);
     boolean deleteVehicle(Long id);
}
