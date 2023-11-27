package com.gtmsoftware.fleetwise.vehiclemaster.controlller;

import com.gtmsoftware.fleetwise.vehiclemaster.model.dto.VehicleDTO;
import com.gtmsoftware.fleetwise.vehiclemaster.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {


    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    /*to retrieve all vehicles details*/
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles()
    {
         List<VehicleDTO> vehicleDTOList = vehicleService.getAllVehicles();
         if(vehicleDTOList.isEmpty())
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         else
             return new ResponseEntity<>(vehicleDTOList,HttpStatus.OK);
    }

    /*to retrieve vehicle details by id */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getAllVehicleByID(@PathVariable Long id)
    {
        VehicleDTO vehicleDTO = vehicleService.getVehicleById(id);

        if(vehicleDTO!=null)
            return new ResponseEntity<>(vehicleDTO,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    /*to add new vehicle Entry in master */
    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO)
    {
          VehicleDTO saveVehicle = vehicleService.createVehicle(vehicleDTO);
          return new ResponseEntity<>(saveVehicle,HttpStatus.CREATED);
    }

    /*to add update existing vehicle Entry in master  */
    @PutMapping
    public ResponseEntity updateVehicle( @RequestBody VehicleDTO vehicleDTO)
    {
          VehicleDTO updatedObj = vehicleService.updateVehicle(vehicleDTO);
          if(updatedObj!=null)
              return  new ResponseEntity("Vehicle Data Successfully Updated",HttpStatus.OK);
          else
              return new ResponseEntity("There are some issue to update Vehicle details in Master",HttpStatus.NOT_MODIFIED);

    }


    /*to add delete existing vehicle Entry in master  */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@PathVariable Long id)
    {
              Boolean isDeleted = vehicleService.deleteVehicle(id);
              if(isDeleted)
                  return new ResponseEntity("vehicle Entry Successfully  deleted from  vehicleMaster",HttpStatus.OK);
              else
                 return  new ResponseEntity("There are some issue to delete the vehicle",HttpStatus.EXPECTATION_FAILED);
    }


}
