package com.gtmsoftware.fleetwise.vehiclemaster.controlller;

import com.gtmsoftware.fleetwise.vehiclemaster.model.dto.VehicleDTO;
import com.gtmsoftware.fleetwise.vehiclemaster.model.entity.Vehicle;
import com.gtmsoftware.fleetwise.vehiclemaster.service.VehicleService;
import com.gtmsoftware.fleetwise.vehiclemaster.util.EntityDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {


    private final VehicleService vehicleService;
    private final EntityDtoMapper entityDtoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    public VehicleController(VehicleService vehicleService, EntityDtoMapper entityDtoMapper) {
        this.vehicleService = vehicleService;
        this.entityDtoMapper = entityDtoMapper;
    }


    /*to retrieve all vehicles details*/
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles()
    {
         List<Vehicle> vehicles = vehicleService.getAllVehicles();
         if(vehicles.isEmpty()) {
             LOGGER.info("There are some issue to fetch data from DB");
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         else {
             LOGGER.info("fetch all  vehicles data from database");
             return new ResponseEntity<>(entityDtoMapper.mapList(vehicles, VehicleDTO.class), HttpStatus.OK);
         }
    }

    /*to retrieve vehicle details by id */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleByID(@PathVariable Long id)
    {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);

        if(vehicle.isPresent()) {
            LOGGER.info("Vehicle data found for this id :{} is {} ",id,vehicle.get());
            return new ResponseEntity<>(entityDtoMapper.convertToDto(vehicle.get()), HttpStatus.OK);
        }
        else {
            LOGGER.info(" No Vehicle data found for this id :{} ",id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /*to add new vehicle Entry in master */
    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO)
    {
        vehicleDTO.setCreateAT(Timestamp.valueOf(LocalDateTime.now()));
        vehicleDTO.setCreatedBy("CreateUser");
        Vehicle vehicle = vehicleService.saveOrUpdateVehicle(entityDtoMapper.convertToEntity(vehicleDTO));
        LOGGER.info("new Vehicle entry  has been successfully saved in database");
          return new ResponseEntity<>(entityDtoMapper.convertToDto(vehicle),HttpStatus.CREATED);
    }

    /*to add update existing vehicle Entry in master  */
    @PutMapping
    public ResponseEntity updateVehicle( @RequestBody VehicleDTO vehicleDTO)
    {
          Optional<Vehicle> vehicle = vehicleService.getVehicleById(vehicleDTO.getId());
               Vehicle updatedObj = null;
        if(vehicle.isPresent()) {
              LOGGER.info("Vehicle record is found for update");
               vehicleDTO.setUpdatedAT(Timestamp.valueOf(LocalDateTime.now()));
               vehicleDTO.setUpdatedBy("updatedUser");
            updatedObj = vehicleService.saveOrUpdateVehicle(entityDtoMapper.convertToEntity(vehicleDTO));
        }
        else {
            LOGGER.info("There are some issue to  fetch record to update the vehicle data");
            return new ResponseEntity("There are some issue to update the vehicle data", HttpStatus.EXPECTATION_FAILED);
        }

          if(updatedObj!=null) {
              LOGGER.info("Vehicle records have been updated successfully in database ");
              return new ResponseEntity("Vehicle Data Successfully Updated", HttpStatus.OK);
          }
          else {
              LOGGER.info("getting some issue while updating  vehicle data ");
              return new ResponseEntity("There are some issue to update Vehicle details in Master", HttpStatus.NOT_MODIFIED);
          }
    }


    /*to add delete existing vehicle Entry in master  */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@PathVariable Long id)
    {
              Boolean isDeleted = vehicleService.deleteVehicle(id);
              if(isDeleted) {
                  LOGGER.info("vehicle data has been successfully deleted ");
                  return new ResponseEntity("vehicle Entry Successfully  deleted from  vehicleMaster", HttpStatus.OK);
              }
              else
                  LOGGER.info("There are some issue to delete the vehicle");
                 return  new ResponseEntity("There are some issue to delete the vehicle",HttpStatus.EXPECTATION_FAILED);
    }


}
