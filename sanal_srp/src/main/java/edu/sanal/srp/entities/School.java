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

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int schoolId;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "school_code")
	private String schoolCode;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_updated_by")
	private int lastUpdatedBy;

	@Column(name = "last_updation_date")
	private String lastUpdationDate;

}
