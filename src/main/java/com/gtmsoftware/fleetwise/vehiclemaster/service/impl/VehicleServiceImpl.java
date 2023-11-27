package com.gtmsoftware.fleetwise.vehiclemaster.service.impl;

import com.gtmsoftware.fleetwise.vehiclemaster.model.dto.VehicleDTO;
import com.gtmsoftware.fleetwise.vehiclemaster.model.entity.Vehicle;
import com.gtmsoftware.fleetwise.vehiclemaster.repository.VehicleRepository;
import com.gtmsoftware.fleetwise.vehiclemaster.service.VehicleService;
import com.gtmsoftware.fleetwise.vehiclemaster.util.EntityDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private EntityDtoMapper entityDtoMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, EntityDtoMapper entityDtoMapper) {
        this.vehicleRepository = vehicleRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
          List<Vehicle>  vehicles =  vehicleRepository.findAll();
          return entityDtoMapper.mapList(vehicles,VehicleDTO.class);
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
          Vehicle vehicle = vehicleRepository.getReferenceById(id);
          return entityDtoMapper.convertToDto(vehicle);
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
           Vehicle v = entityDtoMapper.convertToEntity(vehicleDTO);
           Vehicle save = vehicleRepository.save(v);
           return entityDtoMapper.convertToDto(save);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO userDTO) {
        return null;
    }

    @Override
    public boolean deleteVehicle(Long id) {
        return false;
    }
}
