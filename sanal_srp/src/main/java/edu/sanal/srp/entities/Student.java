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

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "student_extra_uq_no")
	private String studentExtraUqNo;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_surname")
	private String studentSurname;

	@Column(name = "student_gender")
	private String studentGender;

	@Column(name = "student_dob")
	private String studentDob;

	@Column(name = "poc_name")
	private String pocName;

	@Column(name = "poc_contact_no")
	private String pocContactNo;

	@Column(name = "relation")
	private String pocRelation;

	@Column(name = "student_aadhar_no")
	private String studentAadharNo;

	@Column(name = "edu_aadhar_no")
	private String eduAadharNo;

	@Column(name = "religion")
	private String religion;

	@Column(name = "caste")
	private String caste;

	@ManyToOne
	@JoinColumn(name = "present_address_id")
	private Address presentAddress;

	@ManyToOne
	@JoinColumn(name = "permanent_address_id")
	private Address permanentAddress;

	@ManyToOne
	@JoinColumn(name = "previous_school_id")
	private School previousSchool;

	@Column(name = "previous_class")
	private String previousClass;

	@Column(name = "past_edu_additional_info")
	private String pastEduAdditionalInfo;

	@Column(name = "tc_number")
	private String tcNumber;

	@Column(name = "identification_mark_one")
	private String identificationMarkOne;

	@Column(name = "identification_mark_two")
	private String identificationMarkTwo;

	@Column(name = "disability")
	private String disability;

	@Column(name = "disability_additional_info")
	private String disabilityAdditionalInfo;

	@Column(name = "required_aid")
	private String requiredAid;

	@Column(name = "aid_additonal_info")
	private String aidAdditionalInfo;

	@ManyToOne
	@JoinColumn(name = "commuting_from")
	private Address commutingFrom;

	@Column(name = "commuting_by")
	private String commutingBy;

	@Column(name = "profile_pic_url")
	private String profilePicUrl;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_updated_by")
	private int lastUpdatedBy;

	@Column(name = "last_updation_date")
	private Date lastUpdationDate;

}