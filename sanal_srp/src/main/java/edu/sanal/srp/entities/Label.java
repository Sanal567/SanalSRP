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
@Table(name = "Labels")
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "label_id")
	private int labelId;
	@Column(name = "label_name")
	private String labelName;
	@Column(name = "label_additional_info")
	private String labelAdditionalInfo;
	@Column(name = "label_category")
	private String labelCategory;
	@Column(name = "created_by")
	private int createdBy;
	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "last_updated_by")
	private int lastUpdateBy;
	@Temporal(TemporalType.DATE)
	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

	public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelAdditionalInfo() {
		return labelAdditionalInfo;
	}

	public void setLabelAdditionalInfo(String labelAdditionalInfo) {
		this.labelAdditionalInfo = labelAdditionalInfo;
	}

	public String getLabelCategory() {
		return labelCategory;
	}

	public void setLabelCategory(String labelCategory) {
		this.labelCategory = labelCategory;
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

	public int getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(int lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdationDate() {
		return lastUpdationDate;
	}

	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + labelId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Label other = (Label) obj;
		if (labelId != other.labelId)
			return false;
		return true;
	}
}