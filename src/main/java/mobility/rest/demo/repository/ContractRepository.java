package mobility.rest.demo.repository;

import java.util.List;
import mobility.rest.demo.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

  List<Contract> findByCustomerId(Long customerId);

  List<Contract> findByVehicleId(Long vehicleId);
}
