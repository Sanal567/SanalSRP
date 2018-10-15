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

import lombok.Data;

@Data
@Table(name = "sanal.bill")
@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_no")
	private long billNo;

	@Column(name = "bill_date")
	private Date billDate;

	@Column(name = "billed_by")
	private String billedBy;

	@Column(name = "paid_by")
	private String paidBy;

	@Column(name = "bill_additonal_info")
	private String billAdditionalInfo;

	@Column(name = "billed_amount")
	private double billedAmount;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "discount_amount")
	private double discountAmount;

	@OneToMany(mappedBy = "bill")
	private Set<Payment> payments;

}
