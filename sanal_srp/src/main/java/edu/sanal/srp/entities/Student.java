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

@Entity
@Table(name = "Students")
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentExtraUqNo() {
		return studentExtraUqNo;
	}

	public void setStudentExtraUqNo(String studentExtraUqNo) {
		this.studentExtraUqNo = studentExtraUqNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getPocName() {
		return pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public String getPocContactNo() {
		return pocContactNo;
	}

	public void setPocContactNo(String pocContactNo) {
		this.pocContactNo = pocContactNo;
	}

	public String getPocRelation() {
		return pocRelation;
	}

	public void setPocRelation(String pocRelation) {
		this.pocRelation = pocRelation;
	}

	public String getStudentAadharNo() {
		return studentAadharNo;
	}

	public void setStudentAadharNo(String studentAadharNo) {
		this.studentAadharNo = studentAadharNo;
	}

	public String getEduAadharNo() {
		return eduAadharNo;
	}

	public void setEduAadharNo(String eduAadharNo) {
		this.eduAadharNo = eduAadharNo;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public School getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(School previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getPreviousClass() {
		return previousClass;
	}

	public void setPreviousClass(String previousClass) {
		this.previousClass = previousClass;
	}

	public String getPastEduAdditionalInfo() {
		return pastEduAdditionalInfo;
	}

	public void setPastEduAdditionalInfo(String pastEduAdditionalInfo) {
		this.pastEduAdditionalInfo = pastEduAdditionalInfo;
	}

	public String getTcNumber() {
		return tcNumber;
	}

	public void setTcNumber(String tcNumber) {
		this.tcNumber = tcNumber;
	}

	public String getIdentificationMarkOne() {
		return identificationMarkOne;
	}

	public void setIdentificationMarkOne(String identificationMarkOne) {
		this.identificationMarkOne = identificationMarkOne;
	}

	public String getIdentificationMarkTwo() {
		return identificationMarkTwo;
	}

	public void setIdentificationMarkTwo(String identificationMarkTwo) {
		this.identificationMarkTwo = identificationMarkTwo;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getDisabilityAdditionalInfo() {
		return disabilityAdditionalInfo;
	}

	public void setDisabilityAdditionalInfo(String disabilityAdditionalInfo) {
		this.disabilityAdditionalInfo = disabilityAdditionalInfo;
	}

	public String getRequiredAid() {
		return requiredAid;
	}

	public void setRequiredAid(String requiredAid) {
		this.requiredAid = requiredAid;
	}

	public String getAidAdditionalInfo() {
		return aidAdditionalInfo;
	}

	public void setAidAdditionalInfo(String aidAdditionalInfo) {
		this.aidAdditionalInfo = aidAdditionalInfo;
	}

	public Address getCommutingFrom() {
		return commutingFrom;
	}

	public void setCommutingFrom(Address commutingFrom) {
		this.commutingFrom = commutingFrom;
	}

	public String getCommutingBy() {
		return commutingBy;
	}

	public void setCommutingBy(String commutingBy) {
		this.commutingBy = commutingBy;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
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
