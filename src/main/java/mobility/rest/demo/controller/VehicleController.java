package mobility.rest.demo.controller;

import mobility.rest.demo.domain.Vehicle;
import mobility.rest.demo.exception.ResourceNotFoundException;
import mobility.rest.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

  @Autowired
  private VehicleRepository vehicleRepository;

  @GetMapping("/vehicles")
  public Page<Vehicle> getVehicles(Pageable pageable) {
    return vehicleRepository.findAll(pageable);
  }

  @GetMapping("/vehicle/{vehicleId}")
  public Vehicle getVehicle(@PathVariable Long vehicleId) {
    return vehicleRepository.findById(vehicleId)
        .orElseThrow(()
            -> new ResourceNotFoundException("Vehicle not found: " + vehicleId));
  }

  @PostMapping("/vehicles")
  public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

}
