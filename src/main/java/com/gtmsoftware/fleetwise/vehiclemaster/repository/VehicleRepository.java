package com.gtmsoftware.fleetwise.vehiclemaster.repository;

import com.gtmsoftware.fleetwise.vehiclemaster.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
