package org.sanal.srp.entities;

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

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.classes")
public class EduClass {
//Class code means?....class_name means, wht abt classDesc
	
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

}
