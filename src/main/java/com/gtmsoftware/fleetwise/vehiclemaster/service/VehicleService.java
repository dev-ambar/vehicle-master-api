package com.gtmsoftware.fleetwise.vehiclemaster.service;

import com.gtmsoftware.fleetwise.vehiclemaster.model.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(Long id);
    VehicleDTO createVehicle(VehicleDTO userDTO);
    VehicleDTO updateVehicle(VehicleDTO userDTO);
    boolean deleteVehicle(Long id);
}
