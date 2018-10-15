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
@Table(name = "sanal.associations")
public class Association {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "association_id")
	private int associationId;

	@Column(name = "this_id")
	private int thisId;

	@Column(name = "that_id")
	private int thatId;

	@ManyToOne
	@JoinColumn(name = "association_type_id")
	private AssociationType associationType;

	@Column(name = "association_additional_info")
	private String associationAdditionalInfo;

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
