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

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.guardians")
public class Guardian {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guardian_id")
	private int guardianId;

	@Column(name = "guardian_name")
	private String guardianName;

	@Column(name = "guardian_contact_no")
	private String guardianContactNo;

	@Column(name = "guardian_occpation")
	private String guardianOccupation;

	@Column(name = "guardian_aadhar_no")
	private String guardianAadharNo;

	@JoinColumn(name = "guardian_address_id")
	@ManyToOne
	private Address guardianAddress;

	@Column(name = "gender")
	private String gender;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_updated_by")
	private int lastUpdatedBy;

	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

}
