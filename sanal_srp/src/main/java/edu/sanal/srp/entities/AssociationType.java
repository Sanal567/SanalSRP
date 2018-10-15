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

@Entity
@Table(name="AssociationTypes")
public class AssociationType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="association_type_id")
	private int associationTypeId;
	@Column(name="association_type_name")
	private String associationTypeName;
	@Column(name="association_category")
	private String associationCategory;
	@Column(name="association_type_additional_info")
	private String associationTypeAdditionalInfo;
	@Column(name="createdBy")
	private int created_by;
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="last_updated_by")
	private int lastUpdatedBy;
	@Temporal(TemporalType.DATE)
	@Column(name="last_updation_date")
	private Date lastUpdationDate;
	public int getAssociationTypeId() {
		return associationTypeId;
	}
	public void setAssociationTypeId(int associationTypeId) {
		this.associationTypeId = associationTypeId;
	}
	public String getAssociationTypeName() {
		return associationTypeName;
	}
	public void setAssociationTypeName(String associationTypeName) {
		this.associationTypeName = associationTypeName;
	}
	public String getAssociationCategory() {
		return associationCategory;
	}
	public void setAssociationCategory(String associationCategory) {
		this.associationCategory = associationCategory;
	}
	public String getAssociationTypeAdditionalInfo() {
		return associationTypeAdditionalInfo;
	}
	public void setAssociationTypeAdditionalInfo(String associationTypeAdditionalInfo) {
		this.associationTypeAdditionalInfo = associationTypeAdditionalInfo;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
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
