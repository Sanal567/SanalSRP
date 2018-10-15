package edu.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Guardians")
public class Guardian {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="guardian_id")
	private int guardianId;
	@Column(name="guardian_name")
	private String guardianName;
	@Column(name="guardian_contact_no")
	private String guardianContactNo;
	@Column(name="guardian_occpation")
	private String guardianOccupation;
	@Column(name="guardian_aadhar_no")
	private String guardianAadharNo;
	@JoinColumn(name="guardian_address_id")
	@ManyToOne
	private Address guardianAddress;
	@Column(name="gender")
	private String gender;
	@Column(name="created_by")
	private int createdBy;
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="last_updated_by")
	private int lastUpdatedBy;
	@Column(name="last_updation_date")
	private Date lastUpdationDate;
	public int getGuardianId() {
		return guardianId;
	}
	public void setGuardianId(int guardianId) {
		this.guardianId = guardianId;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getGuardianContactNo() {
		return guardianContactNo;
	}
	public void setGuardianContactNo(String guardianContactNo) {
		this.guardianContactNo = guardianContactNo;
	}
	public String getGuardianOccupation() {
		return guardianOccupation;
	}
	public void setGuardianOccupation(String guardianOccupation) {
		this.guardianOccupation = guardianOccupation;
	}
	public String getGuardianAadharNo() {
		return guardianAadharNo;
	}
	public void setGuardianAadharNo(String guardianAadharNo) {
		this.guardianAadharNo = guardianAadharNo;
	}
	public Address getGuardianAddress() {
		return guardianAddress;
	}
	public void setGuardianAddress(Address guardianAddress) {
		this.guardianAddress = guardianAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
