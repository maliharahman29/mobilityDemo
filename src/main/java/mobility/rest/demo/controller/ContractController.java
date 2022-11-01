package mobility.rest.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mobility.rest.demo.domain.Contract;
import mobility.rest.demo.dto.response.ContractDTO;
import mobility.rest.demo.exception.ResourceNotFoundException;
import mobility.rest.demo.mapper.ContractMapper;
import mobility.rest.demo.repository.ContractRepository;
import mobility.rest.demo.repository.CustomerRepository;
import mobility.rest.demo.repository.VehicleRepository;
import mobility.rest.demo.vo.request.ContractVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ContractController {

  private final ContractMapper contractMapper;

  private ContractVO contractVO;

  public ContractController(ContractMapper contractMapper) {
    this.contractMapper = contractMapper;
  }

  @Autowired
  ContractRepository contractRepository;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  VehicleRepository vehicleRepository;

  @GetMapping("/customers/{customerId}/contracts")
  public List<Contract> getContractByCustomerId(@PathVariable Long customerId) {
    return contractRepository.findByCustomerId(customerId);
  }

  @GetMapping("/vehicles/{vehicleId}/contracts")
  public List<Contract> getContractByVehicleId(@PathVariable Long vehicleId) {
    return contractRepository.findByVehicleId(vehicleId);
  }

  @GetMapping("/contracts")
  public List<Contract> getAllContracts() {
    return contractRepository.findAll();
  }

  @GetMapping("/contracts/overview")
  public ResponseEntity<List<ContractDTO>> getAllContractsOverview() {

    List<ContractVO> contractVOList = contractRepository.findAll().stream()
        .map(contractMapper::mapToVO).collect(
            Collectors.toList()
        );

    List<ContractDTO> contractDTOList = contractMapper.mapToDTOs(contractVOList);

    contractDTOList.stream().map(
        contractDTO -> {
         // contractDTO.setVehicleYear(contractDTO.getVehicleYear().);
          contractDTO.setName(contractDTO.getFirstName() + " " + contractDTO.getLastName());
          contractDTO.setCombineVehicle(
              contractDTO.getVehicleBrand() +
                  " " + contractDTO.getVehicleModel() + " " +
                  "(" + contractDTO.getVehicleYear() + ")");
          return true;
        }
    ).collect(Collectors.toList());

    return ResponseEntity.ok(contractDTOList);
  }

  @PostMapping("/customers/{customerId}/vehicles/{vehicleId}/contracts")
  public Contract addContract(@PathVariable Long customerId,
      @PathVariable Long vehicleId,
      @Valid @RequestBody Contract contract) {

    if (customerRepository.findById(customerId).isPresent() && vehicleRepository.findById(vehicleId)
        .isPresent()) {

      customerRepository.findById(customerId)
          .map(customer -> {
            contract.setCustomer(customer);
            return Optional.empty();
          });

      vehicleRepository.findById(vehicleId)
          .map(vehicle -> {
            contract.setVehicle(vehicle);
            return Optional.empty();
          });

      return contractRepository.save(contract);
    } else {
      throw new ResourceNotFoundException("Resource not found");
    }
  }
}
