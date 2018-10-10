package com.example.demo.entity;
// Generated Oct 10, 2018 2:06:31 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FlightCosts generated by hbm2java
 */
@Entity
@Table(name = "flight_costs")
public class FlightCosts implements java.io.Serializable {

	private Integer flightNumber;
	private int aircraftTypeCode;
	private int validFromDate;
	private int validToDate;
	private int flightCost;

	public FlightCosts() {
	}

	public FlightCosts(int aircraftTypeCode, int validFromDate, int validToDate, int flightCost) {
		this.aircraftTypeCode = aircraftTypeCode;
		this.validFromDate = validFromDate;
		this.validToDate = validToDate;
		this.flightCost = flightCost;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "flight_number", unique = true, nullable = false)
	public Integer getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	@Column(name = "aircraft_type_code", nullable = false)
	public int getAircraftTypeCode() {
		return this.aircraftTypeCode;
	}

	public void setAircraftTypeCode(int aircraftTypeCode) {
		this.aircraftTypeCode = aircraftTypeCode;
	}

	@Column(name = "valid_from_date", nullable = false)
	public int getValidFromDate() {
		return this.validFromDate;
	}

	public void setValidFromDate(int validFromDate) {
		this.validFromDate = validFromDate;
	}

	@Column(name = "valid_to_date", nullable = false)
	public int getValidToDate() {
		return this.validToDate;
	}

	public void setValidToDate(int validToDate) {
		this.validToDate = validToDate;
	}

	@Column(name = "flight_cost", nullable = false)
	public int getFlightCost() {
		return this.flightCost;
	}

	public void setFlightCost(int flightCost) {
		this.flightCost = flightCost;
	}

}
