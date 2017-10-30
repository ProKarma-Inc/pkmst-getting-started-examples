package com.prokarma.pkmst.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Response class to be returned by Api
 * @author pkmst
 *
 */
/**
 * Car
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-26T02:45:52.152Z")

@Document
public class Car   {
	@Id
  private Long id = null;

  private String vinNumber = null;

  private String make = null;

  private String model = null;

  private Integer year = null;
  
  public Car() {
	}

	public Car(Long id,String vinNumber, String make, String model, int year) {
		super();
		this.id = id;
		this.vinNumber = vinNumber;
		this.make = make;
		this.model = model;
		this.year = year;
	}

  
   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  
   /**
   * Get vinNumber
   * @return vinNumber
  **/
  @ApiModelProperty(value = "")
  public String getVinNumber() {
    return vinNumber;
  }

   /**
   * Get make
   * @return make
  **/
  @ApiModelProperty(value = "")
  public String getMake() {
    return make;
  }


   /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(value = "")
  public String getModel() {
    return model;
  }

   /**
   * Car making Year
   * @return year
  **/
  @ApiModelProperty(value = "Car making Year")
  public Integer getYear() {
    return year;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(this.id, car.id) &&
        Objects.equals(this.vinNumber, car.vinNumber) &&
        Objects.equals(this.make, car.make) &&
        Objects.equals(this.model, car.model) &&
        Objects.equals(this.year, car.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vinNumber, make, model, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Car {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    vinNumber: ").append(toIndentedString(vinNumber)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

