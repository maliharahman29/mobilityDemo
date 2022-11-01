package mobility.rest.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_contract")
public class Contract {

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  @JsonIgnore
  private Customer customer;

  @OneToOne
  @JoinColumn(name = "vehicle_id", nullable = false)
  @JsonIgnore
  private Vehicle vehicle;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long contractNumber;

  @NotNull
  private double monthlyRate;

  public Contract() {
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Long getContractNumber() {
    return contractNumber;
  }

  public double getMonthlyRate() {
    return monthlyRate;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setContractNumber(Long contractNumber) {
    this.contractNumber = contractNumber;
  }

  public void setMonthlyRate(double monthlyRate) {
    this.monthlyRate = monthlyRate;
  }

}
