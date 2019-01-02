package org.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "door_or_house_no", length = 15)
	private String doorOrHouseNo;

	@Column(name = "street_one", nullable = false, length = 50)
	private String streetOne;

	@Column(name = "street_two", length = 40)
	private String streetTwo;

	@Column(name = "landmark")
	private String landmark;

	@Column(name="mandal", nullable = false, length = 40)
	private String mandal;
	
	@Column(name = "district", nullable = false, length = 40)
	private String district;

	@Column(name = "pin_no", nullable = false)
	private int pinCode;

	@Column(name = "additional_info")
	private String additionalInfo;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_updated_by")
	private int lastUpdatedBy;

	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

}
