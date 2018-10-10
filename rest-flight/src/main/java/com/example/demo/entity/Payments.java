package com.example.demo.entity;
// Generated Oct 10, 2018 2:06:31 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Payments generated by hbm2java
 */
@Entity
@Table(name = "payments")
public class Payments implements java.io.Serializable {

	private Integer paymentId;
	private int paymentStatusCode;
	private Date paymentDate;
	private int paymentAmount;

	public Payments() {
	}

	public Payments(int paymentStatusCode, Date paymentDate, int paymentAmount) {
		this.paymentStatusCode = paymentStatusCode;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "payment_id", unique = true, nullable = false)
	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "payment_status_code", nullable = false)
	public int getPaymentStatusCode() {
		return this.paymentStatusCode;
	}

	public void setPaymentStatusCode(int paymentStatusCode) {
		this.paymentStatusCode = paymentStatusCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date", nullable = false, length = 10)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "payment_amount", nullable = false)
	public int getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}