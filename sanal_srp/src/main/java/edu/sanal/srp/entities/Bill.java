package edu.sanal.srp.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_no")
	private long billNo;
	@Column(name="bill_date")
	private Date billDate;
	@Column(name="billed_by")
	private String billedBy;
	@Column(name="paid_by")
	private String paidBy;
	@Column(name="bill_additonal_info")
	private String billAdditionalInfo;
	@Column(name="billed_amount")
	private double billedAmount;
	@Column(name="total_amount")
	private double totalAmount;
	@Column(name="discount_amount")
	private double discountAmount;
	@OneToMany(mappedBy="bill")
	private Set<Payment> payments;
	public long getBillNo() {
		return billNo;
	}
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBilledBy() {
		return billedBy;
	}
	public void setBilledBy(String billedBy) {
		this.billedBy = billedBy;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	public String getBillAdditionalInfo() {
		return billAdditionalInfo;
	}
	public void setBillAdditionalInfo(String billAdditionalInfo) {
		this.billAdditionalInfo = billAdditionalInfo;
	}
	public double getBilledAmount() {
		return billedAmount;
	}
	public void setBilledAmount(double billedAmount) {
		this.billedAmount = billedAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
}
