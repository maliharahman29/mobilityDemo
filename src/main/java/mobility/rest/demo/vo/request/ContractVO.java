package mobility.rest.demo.vo.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import mobility.rest.demo.domain.Customer;
import mobility.rest.demo.domain.Vehicle;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class ContractVO {

  public static final long serialVersionUID = 1L;

  private long contractNumber;

  private long monthlyRate;

  private Customer customer;

  private String firstName;

  private String lastName;

  private Vehicle vehicle;

  private String vin;

  private double vehiclePrice;

  private String vehicleBrand;

  private String vehicleModel;

  @DateTimeFormat(pattern = "yyyy")
  private Date vehicleYear;
}
