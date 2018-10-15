package edu.sanal.srp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Class_Section")
public class ClassSection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_section_id")
	private int classSectionId;
	@Column(name="section_name")
	private String sectionName;
	@Column(name="section_additional_info")
	private String sectionAdditionalInfo;
	@ManyToOne
	@JoinColumn(name="section_id")
	private Section section; 
	public int getClassSectionId() {
		return classSectionId;
	}
	public void setClassSectionId(int classSectionId) {
		this.classSectionId = classSectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSectionAdditionalInfo() {
		return sectionAdditionalInfo;
	}
	public void setSectionAdditionalInfo(String sectionAdditionalInfo) {
		this.sectionAdditionalInfo = sectionAdditionalInfo;
	}

	
}
