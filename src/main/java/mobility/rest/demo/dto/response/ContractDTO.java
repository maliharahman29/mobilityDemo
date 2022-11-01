package mobility.rest.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mobility.rest.demo.domain.Customer;
import mobility.rest.demo.domain.Vehicle;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContractDTO extends BaseDTO implements Serializable {

  public static final long serialVersionUID = 1L;

  private long contractNumber;

  private long monthlyRate;

  @JsonIgnore
  private String firstName;

  @JsonIgnore
  private String lastName;

  private Customer customer;

  private String name;

  private Vehicle vehicle;

  private String vin;

  private double vehiclePrice;

  @JsonIgnore
  private String vehicleBrand;

  @JsonIgnore
  private String vehicleModel;

  @JsonIgnore
  @DateTimeFormat(pattern = "yyyy")
  private Date vehicleYear;

  private String combineVehicle;
}
