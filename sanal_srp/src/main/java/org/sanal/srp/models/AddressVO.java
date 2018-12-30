package org.sanal.srp.models;

public class AddressVO {
	private int addressId;
	private String doorOrHouseNo;
	private String streetOne;
	private String streetTwo;
	private String landmark;
	private String district;
	private String pinNo;
	private String additionalInfo;
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
	
}
