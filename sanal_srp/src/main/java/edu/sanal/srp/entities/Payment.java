package edu.sanal.srp.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private long paymentId;
	@Column(name="student_id")
	private int studentId;
	@Column(name="student_extra_uq_no")
	private String studentExtraUqNo;
	@Column(name="student_name")
	private String studentName;
	@Column(name="student_surname")
	private String studentSurname;
	@Column(name="class_id")
	private int classId;
	@Column(name="class_code")
	private String classCode;
	@Column(name="class_name")
	private String className;
	@Column(name="class_desc")
	private String classDesc;
	@Column(name="amount")
	private double amount;
	@Column(name="discount_amount")
	private double discountAmount;
	@Column(name="total_amount")
	private double totalAmount;
	@ManyToOne
	@JoinColumn(name="bill_no")
	private Bill bill;
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
}
