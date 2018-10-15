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
@Table(name = "sanal.payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private long paymentId;

	@Column(name = "student_id")
	private int studentId;

	@Column(name = "student_extra_uq_no")
	private String studentExtraUqNo;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_surname")
	private String studentSurname;

	@Column(name = "class_id")
	private int classId;

	@Column(name = "class_code")
	private String classCode;

	@Column(name = "class_name")
	private String className;

	@Column(name = "class_desc")
	private String classDesc;

	@Column(name = "amount")
	private double amount;

	@Column(name = "discount_amount")
	private double discountAmount;

	@Column(name = "total_amount")
	private double totalAmount;

	@ManyToOne
	@JoinColumn(name = "bill_no")
	private Bill bill;

}
