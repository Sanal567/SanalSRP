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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.admissions")
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admission_id")
	private int admissionId;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Temporal(TemporalType.DATE)
	@Column(name = "admitted_date")
	private Date admittedDate;

	@Column(name = "admission_status")
	private String admissionStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "relieved_date")
	private Date relievedDate;

	@Column(name = "created_by")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

}
