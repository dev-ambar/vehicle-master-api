package com.gtmsoftware.fleetwise.vehiclemaster.service.impl;

import com.gtmsoftware.fleetwise.vehiclemaster.model.entity.Vehicle;
import com.gtmsoftware.fleetwise.vehiclemaster.repository.VehicleRepository;
import com.gtmsoftware.fleetwise.vehiclemaster.service.VehicleService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle saveOrUpdateVehicle(Vehicle vehicle) {
          return vehicleRepository.saveAndFlush(vehicle);
    }


    @Override
    public boolean deleteVehicle(Long id) {
        Optional<Vehicle> vehicle  = vehicleRepository.findById(id);
        if(vehicle.isPresent())
        {
              Vehicle deleted =  vehicle.get();
              deleted.setIsActive("N");
              deleted.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
              deleted.setUpdatedBy("updatedUser");
              vehicleRepository.saveAndFlush(deleted);
              return true;
        }
        else return false;
    }
}
