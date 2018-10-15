package edu.sanal.srp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.association_type")
public class AssociationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "association_type_id")
	private int associationTypeId;

	@Column(name = "association_type_name")
	private String associationTypeName;

	@Column(name = "association_category")
	private String associationCategory;

	@Column(name = "association_type_additional_info")
	private String associationTypeAdditionalInfo;

	@Column(name = "createdBy")
	private int created_by;

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

}
