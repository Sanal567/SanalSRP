package org.sanal.srp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "sanal.students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;

	// which no we have to enter
	@Column(name = "student_extra_uq_no", nullable = true)
	private String studentExtraUqNo;

	@Size(min = 3, max = 50)
	@Column(name = "student_name", length = 50, nullable = false)
	private String firstName;

	@Size(min = 3, max = 50)
	@Column(name = "student_surname", length = 50, nullable = false)
	private String lastName;

	@NotNull
	@Column(name = "student_gender", nullable = false)
	private Boolean studentGender;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "DD/MM/YYYY")
	@Temporal(TemporalType.DATE)
	@Column(name = "student_dob", nullable = false)
	private String studentDob;

	@Size(min = 3, max = 50)
	@Column(name = "poc_name", nullable = false)
	private String pocName;

//	@Phone
	@Column(name = "poc_contact_no", nullable = false)
	private String pocContactNo;

//	@Size()
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

	@Column(name = "commuting_by")
	private String commutingBy;

	// @OneToOne -- sunil, to save all the present and future address
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "present_address_id")
	private Address presentAddress;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "permanent_address_id")
	private Address permanentAddress;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "previous_school_id")
	private School previousSchool;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "commuting_from")
	private Address commutingFrom;

	@Column(name = "created_by", nullable = false)
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@Column(name = "last_updated_by", nullable = false)
	private int lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_updation_date", nullable = false)
	private Date lastUpdationDate;

}