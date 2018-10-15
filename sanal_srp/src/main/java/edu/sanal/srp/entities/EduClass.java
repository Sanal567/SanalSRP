package edu.sanal.srp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Classes")
public class EduClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	private Integer classId;
	
	@Column(name = "class_code")
	private String classCode;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "class_desc")
	private String classDesc;
	
	@OneToMany
	@JoinColumn(name = "class_id")
	private List<ClassSection> sections;

	@Column(name = "created_by")
	private Integer createdBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "last_updated_by")
	private Integer lastUpdatedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
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
