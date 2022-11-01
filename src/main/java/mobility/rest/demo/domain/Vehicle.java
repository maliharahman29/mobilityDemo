package mobility.rest.demo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_vehicle")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Vehicle extends AbstractAuditable {

  @NotNull
  @NotEmpty
  private String brand;

  @NotNull
  @NotEmpty
  private String model;

  @NotNull
  @DateTimeFormat(pattern = "yyyy")
  private Date year;

  private String vin;

  @NotNull
  private double price;

  @OneToOne(mappedBy = "vehicle")
  private Contract contract;

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYear(Date year) {
    this.year = year;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public Date getYear() {
    return year;
  }

  public String getVin() {
    return vin;
  }

  public double getPrice() {
    return price;
  }
}
