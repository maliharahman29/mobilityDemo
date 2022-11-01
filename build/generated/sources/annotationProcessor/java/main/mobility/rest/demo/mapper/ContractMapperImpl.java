package mobility.rest.demo.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import mobility.rest.demo.domain.Contract;
import mobility.rest.demo.domain.Customer;
import mobility.rest.demo.domain.Vehicle;
import mobility.rest.demo.dto.response.ContractDTO;
import mobility.rest.demo.vo.request.ContractVO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-31T07:32:27+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 13.0.7 (Azul Systems, Inc.)"
)
@Component
public class ContractMapperImpl implements ContractMapper {

    @Override
    public ContractDTO mapToDTO(ContractVO contractVO) {
        if ( contractVO == null ) {
            return null;
        }

        ContractDTO contractDTO = new ContractDTO();

        contractDTO.setContractNumber( contractVO.getContractNumber() );
        contractDTO.setMonthlyRate( contractVO.getMonthlyRate() );
        contractDTO.setFirstName( contractVO.getFirstName() );
        contractDTO.setLastName( contractVO.getLastName() );
        contractDTO.setCustomer( contractVO.getCustomer() );
        contractDTO.setVehicle( contractVO.getVehicle() );
        contractDTO.setVin( contractVO.getVin() );
        contractDTO.setVehiclePrice( contractVO.getVehiclePrice() );
        contractDTO.setVehicleBrand( contractVO.getVehicleBrand() );
        contractDTO.setVehicleModel( contractVO.getVehicleModel() );
        contractDTO.setVehicleYear( contractVO.getVehicleYear() );

        return contractDTO;
    }

    @Override
    public List<ContractDTO> mapToDTOs(List<ContractVO> contractVOList) {
        if ( contractVOList == null ) {
            return null;
        }

        List<ContractDTO> list = new ArrayList<ContractDTO>( contractVOList.size() );
        for ( ContractVO contractVO : contractVOList ) {
            list.add( mapToDTO( contractVO ) );
        }

        return list;
    }

    @Override
    public ContractVO mapToVO(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        ContractVO contractVO = new ContractVO();

        contractVO.setFirstName( contractCustomerFirstName( contract ) );
        contractVO.setLastName( contractCustomerLastName( contract ) );
        contractVO.setVehiclePrice( contractVehiclePrice( contract ) );
        contractVO.setVehicleBrand( contractVehicleBrand( contract ) );
        contractVO.setVehicleModel( contractVehicleModel( contract ) );
        contractVO.setVin( contractVehicleVin( contract ) );
        contractVO.setVehicleYear( contractVehicleYear( contract ) );
        if ( contract.getContractNumber() != null ) {
            contractVO.setContractNumber( contract.getContractNumber() );
        }
        contractVO.setMonthlyRate( (long) contract.getMonthlyRate() );

        return contractVO;
    }

    private String contractCustomerFirstName(Contract contract) {
        if ( contract == null ) {
            return null;
        }
        Customer customer = contract.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String firstName = customer.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String contractCustomerLastName(Contract contract) {
        if ( contract == null ) {
            return null;
        }
        Customer customer = contract.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String lastName = customer.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private double contractVehiclePrice(Contract contract) {
        if ( contract == null ) {
            return 0.0d;
        }
        Vehicle vehicle = contract.getVehicle();
        if ( vehicle == null ) {
            return 0.0d;
        }
        double price = vehicle.getPrice();
        return price;
    }

    private String contractVehicleBrand(Contract contract) {
        if ( contract == null ) {
            return null;
        }
        Vehicle vehicle = contract.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        String brand = vehicle.getBrand();
        if ( brand == null ) {
            return null;
        }
        return brand;
    }

    private String contractVehicleModel(Contract contract) {
        if ( contract == null ) {
            return null;
        }
        Vehicle vehicle = contract.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        String model = vehicle.getModel();
        if ( model == null ) {
            return null;
        }
        return model;
    }

    private String contractVehicleVin(Contract contract) {
        if ( contract == null ) {
            return null;
        }
        Vehicle vehicle = contract.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        String vin = vehicle.getVin();
        if ( vin == null ) {
            return null;
        }
        return vin;
    }

    private Date contractVehicleYear(Contract contract) {
        if ( contract == null ) {
            return null;
        }
        Vehicle vehicle = contract.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        Date year = vehicle.getYear();
        if ( year == null ) {
            return null;
        }
        return year;
    }
}
