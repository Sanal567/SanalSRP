package edu.sanal.srp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sanal.sections")
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="section_name", nullable = false, length = 20)
	private String sectionName;
	
	@Column(name="section_desc", length = 40)
	private String sectionDesc;
	
}