package org.sanal.srp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Cacheable
@Data
@Entity
@Table(name = "sanal.addresses")
public class Address implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "door_or_house_no", length = 50)
	private String doorOrHouseNo;

//	@NotBlank
	@Size(min = 3, max = 50)
	@Column(name = "street_one", nullable = false, length = 50)
	private String streetOne;

//  @NotBlank
//	@Size(min = 3, max = 50)
	@Column(name = "street_two", length = 50)
	private String streetTwo;
	
//	@NotBlank
//	@Size(min  = 5, max = 50 )
	@Column(name = "landmark", length =50)
	private String landmark;

//	@NotBlank
	@Size(min =3, max = 50)
	@Column(name = "mandal", nullable = false, length = 50)
	private String mandal;

//	@NotBlank
	@Size(min = 3, max =50 )
	@Column(name = "district", nullable = false, length = 50)
	private String district;

//	@NotNull
	@Range(min = 500000, max = 699999)
	@Column(name = "pin_no", nullable = false)
	private int pinCode;

	@Column(name = "additional_info", length = 50)
	private String additionalInfo;

	@Column(name = "created_by", nullable = false)
	private int createdBy;

	@Column(name = "creation_date", nullable = false)
	private Date creationDate;
	
	@Column(name = "last_updated_by", nullable = false)
	private int lastUpdatedBy;

	@Column(name = "last_updation_date", nullable = false)
	private Date lastUpdationDate;

}
