package org.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "door_or_house_no", length = 50)
	private String doorOrHouseNo;

	@NotBlank
	@Size(min = 3, max = 50, message = "Street/Village name must be between 3 to 50 characters")
	@Column(name = "street_one", nullable = false, length = 50)
	private String streetOne;

//	@Size(min = 3, max = 50, message = "Area/Panachayat name must be between 3 to 50 characters")
	@Column(name = "street_two", length = 50)
	private String streetTwo;
	
	@NotBlank
	@Size(min  = 5, max = 50 , message = "Landmark must be between 5 to 50 characters length")
	@Column(name = "landmark")
	private String landmark;

	@NotBlank
	@Size(min =5, max = 50, message = "Mandal name must be between 5 to 50 characters length ")
	@Column(name = "mandal", nullable = false, length = 50)
	private String mandal;

	@NotEmpty
	@Size(min = 5, max =50 , message = "District name must be between 3 to 5 characters length")
	@Column(name = "district", nullable = false, length = 50)
	private String district;

	@NotNull(message="PIN Code cannot be empty")
	@Range(min = 500000, max = 699999)
	@Column(name = "pin_no", nullable = false)
	private int pinCode;

	@Column(name = "additional_info")
	private String additionalInfo;

	@NotNull
	@Column(name = "created_by")
	private int createdBy;

	@NotNull
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@NotNull
	@Column(name = "last_updated_by", nullable = false)
	private int lastUpdatedBy;

	@NotNull
	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

}
