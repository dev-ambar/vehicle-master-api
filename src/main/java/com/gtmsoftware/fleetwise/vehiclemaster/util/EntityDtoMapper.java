package com.gtmsoftware.fleetwise.vehiclemaster.util;

import com.gtmsoftware.fleetwise.vehiclemaster.model.dto.VehicleDTO;
import com.gtmsoftware.fleetwise.vehiclemaster.model.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    private final ModelMapper modelMapper;

    public EntityDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, T> List<D> mapList(List<T> sourceList, Class<D> destinationType) {
        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .collect(Collectors.toList());
    }

    public VehicleDTO convertToDto(Vehicle v)
    {
        return modelMapper.map(v, VehicleDTO.class);
    }

    public Vehicle convertToEntity(VehicleDTO vDto)
    {
        return modelMapper.map(vDto, Vehicle.class);
    }
}

