package mobility.rest.demo.mapper;

import java.util.List;
import mobility.rest.demo.domain.Contract;
import mobility.rest.demo.dto.response.ContractDTO;
import mobility.rest.demo.vo.request.ContractVO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ContractMapper {

  ContractDTO mapToDTO(ContractVO contractVO);

  List<ContractDTO> mapToDTOs(List<ContractVO> contractVOList);

  @Mapping(source = "customer", target = "customer", ignore = true)
  @Mapping(source = "customer.firstName", target = "firstName")
  @Mapping(source = "customer.lastName", target = "lastName")
  @Mapping(source = "vehicle", target = "vehicle", ignore = true)
  @Mapping(source = "vehicle.price", target = "vehiclePrice")
  @Mapping(source = "vehicle.brand", target = "vehicleBrand")
  @Mapping(source = "vehicle.model", target = "vehicleModel")
  @Mapping(source = "vehicle.vin", target = "vin")
  @Mapping(source = "vehicle.year", target = "vehicleYear")
  ContractVO mapToVO(Contract contract);
}
