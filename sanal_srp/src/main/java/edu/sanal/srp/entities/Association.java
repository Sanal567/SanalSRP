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
@Table(name="Associations")
public class Association {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="association_id")
	private int associationId;
	@Column(name="this_id")
	private int thisId;
	@Column(name="that_id")
	private int thatId;
	@ManyToOne
	@JoinColumn(name="association_type_id")
	private AssociationType associationType;
	@Column(name="association_additional_info")
	private String associationAdditionalInfo;
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
	public int getAssociationId() {
		return associationId;
	}
	public void setAssociationId(int associationId) {
		this.associationId = associationId;
	}
	public int getThisId() {
		return thisId;
	}
	public void setThisId(int thisId) {
		this.thisId = thisId;
	}
	public int getThatId() {
		return thatId;
	}
	public void setThatId(int thatId) {
		this.thatId = thatId;
	}
	public AssociationType getAssociationType() {
		return associationType;
	}
	public void setAssociationType(AssociationType associationType) {
		this.associationType = associationType;
	}
	public String getAssociationAdditionalInfo() {
		return associationAdditionalInfo;
	}
	public void setAssociationAdditionalInfo(String associationAdditionalInfo) {
		this.associationAdditionalInfo = associationAdditionalInfo;
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
