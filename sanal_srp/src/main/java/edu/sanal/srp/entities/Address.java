package edu.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "door_or_house_no")
	private String doorOrHouseNo;
	@Column(name = "street_one")
	private String streetOne;
	@Column(name = "street_two")
	private String streetTwo;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "district")
	private String district;
	@Column(name = "pin_no")
	private String pinNo;
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

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDoorOrHouseNo() {
		return doorOrHouseNo;
	}

	public void setDoorOrHouseNo(String doorOrHouseNo) {
		this.doorOrHouseNo = doorOrHouseNo;
	}

	public String getStreetOne() {
		return streetOne;
	}

	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	public String getStreetTwo() {
		return streetTwo;
	}

	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdationDate() {
		return lastUpdationDate;
	}

	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}

}
