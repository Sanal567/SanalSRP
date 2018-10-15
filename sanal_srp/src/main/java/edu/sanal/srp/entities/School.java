package edu.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Schools")
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	@Column(name="school_name")
	private String schoolName;
	@Column(name="school_code")
	private String schoolCode;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	@Column(name="created_by")
	private int createdBy;
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="last_updated_by")
	private int lastUpdatedBy;
	@Column(name="last_updation_date")
	private String lastUpdationDate;
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public String getLastUpdationDate() {
		return lastUpdationDate;
	}
	public void setLastUpdationDate(String lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}
	
}
