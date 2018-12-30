package org.sanal.srp.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EduClassVO implements Serializable {

	// Changed int to Integer...
	// in Entity classes use Wrapper classes because they are Serializable
	private Integer classId;
	private String classCode;
	private String className;
	private String classDesc;

	public int getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

}