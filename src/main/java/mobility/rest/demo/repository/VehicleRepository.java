package mobility.rest.demo.repository;

import java.util.List;
import mobility.rest.demo.domain.Contract;
import mobility.rest.demo.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
