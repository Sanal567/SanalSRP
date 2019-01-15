package org.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.admissions")
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admission_id")
	private int admissionId;

//	@OneToOne - mine : student may relieve from the college and rejoin
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable= false)
	private Student student;

	@Temporal(TemporalType.DATE)
	@Column(name = "admitted_date")
	private Date admittedDate;

	@NotNull
	@Column(name = "admission_status", length =1)
	private String admissionStatus;

	// We get TC on any future date i.e. after joining in the school also 
	// @Past
	@Temporal(TemporalType.DATE)
	@Column(name = "relieved_date")
	private Date relievedDate;

	@Column(name = "created_by", nullable = false)
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@Column(name = "last_updated_by", nullable = false)
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_updation_date", nullable = false)
	private Date lastUpdationDate;

}
