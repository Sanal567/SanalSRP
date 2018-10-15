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

@Entity
@Table(name="Admissions")
public class Admission {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admission_id")
	private int admissionId;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	@Temporal(TemporalType.DATE)
	@Column(name="admitted_date")
	private Date admittedDate;
	@Column(name="admission_status")
	private String admissionStatus;
	@Temporal(TemporalType.DATE)
	@Column(name="relieved_date")
	private Date relievedDate;
	@Column(name="created_by")
	private int createdBy;
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="last_updated_by")
	private int lastUpdatedBy;
	@Temporal(TemporalType.DATE)
	@Column(name="last_updation_date")
	private Date lastUpdationDate;
	public int getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getAdmittedDate() {
		return admittedDate;
	}
	public void setAdmittedDate(Date admittedDate) {
		this.admittedDate = admittedDate;
	}
	public String getAdmissionStatus() {
		return admissionStatus;
	}
	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
	public Date getRelievedDate() {
		return relievedDate;
	}
	public void setRelievedDate(Date relievedDate) {
		this.relievedDate = relievedDate;
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
