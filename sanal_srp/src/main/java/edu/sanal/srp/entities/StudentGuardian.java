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
@Table(name="Student_Guardian")
public class StudentGuardian {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_guardian_id")
	private int studentGuardianId;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	@ManyToOne
	@JoinColumn(name="guardian_id")
	private Guardian guardian;
	@Column(name="relation")
	private String relation;
	public int getStudentGuardianId() {
		return studentGuardianId;
	}
	public void setStudentGuardianId(int studentGuardianId) {
		this.studentGuardianId = studentGuardianId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Guardian getGuardian() {
		return guardian;
	}
	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
}
