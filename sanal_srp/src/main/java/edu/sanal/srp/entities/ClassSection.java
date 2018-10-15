package edu.sanal.srp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.class_section")
public class ClassSection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_section_id")
	private int classSectionId;

	@Column(name = "section_name")
	private String sectionName;

	@Column(name = "section_additional_info")
	private String sectionAdditionalInfo;

	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;

}
