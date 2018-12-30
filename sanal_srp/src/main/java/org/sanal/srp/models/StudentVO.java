package org.sanal.srp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StudentVO {
	private int studentId;
	private String studentExtraUqNo;
	private String studentName;
	private String studentSurname;
	private String studentGender;
	private String studentDob;
	private String pocName;
	private String pocContactNo;
	private String pocRelation;
	private String studentAadharNo;
	private String eduAadharNo;
	private String religion;
	private String caste;
	private AddressVO presentAddress;
	private AddressVO permanentAddress;
	private String schoolName;
	private String previousClass;
	private String pastEduAdditionalInfo;
	private String tcNumber;
	private String identificationMarkOne;
	private String identificationMarkTwo;
	private String disability;
	private String disabilityAdditionalInfo;
	private String requiredAid;
	private String aidAdditionalInfo;
	private String commutingFrom;
	private String commutingBy;
	private String profilePicUrl;
}
