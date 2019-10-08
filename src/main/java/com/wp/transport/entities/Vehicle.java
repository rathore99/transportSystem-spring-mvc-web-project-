package com.wp.transport.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Vehicle {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int vehicleId;
	@Column(length = 10)
	private String registrationNo;
	private String chasisNo;
	private String ownerName;
	private String model;
	private String vehicleType;
	private String insuranceProvider;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date insuranceValidity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fitnessValidity;
	private String fitnessCertficate;
	private String insurancePaper;
	private boolean status = false;
	
	@ManyToOne
	@JoinColumn(name="transporterId")
	private Transporter transporter;
	
	@OneToMany(mappedBy="vehicle",cascade= javax.persistence.CascadeType.ALL,fetch = FetchType.LAZY)
	List<Deal>dealList = new ArrayList<Deal>();
	// constructors
	public Vehicle(String registrationNo) {
		super();
		this.registrationNo = registrationNo;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNo=" + registrationNo + ", chasisNo=" + chasisNo + ", ownerName=" + ownerName
				+ ", model=" + model + ", vehicleType=" + vehicleType + "]";
	}


		public Vehicle(String registrationNo, String chasisNo, String ownerName, String model, String vehicleType,
			String insuranceProvider, Date insuranceValidity, Date fitnessValidity, String fitnessCertficate,
			String insurancePaper, boolean status) {
		super();
		this.registrationNo = registrationNo;
		this.chasisNo = chasisNo;
		this.ownerName = ownerName;
		this.model = model;
		this.vehicleType = vehicleType;
		this.insuranceProvider = insuranceProvider;
		this.insuranceValidity = insuranceValidity;
		this.fitnessValidity = fitnessValidity;
		this.fitnessCertficate = fitnessCertficate;
		this.insurancePaper = insurancePaper;
		this.status = status;
	}


	public Vehicle(int vehicleId, String registrationNo, String chasisNo, String ownerName, String model,
				String vehicleType, String insuranceProvider, Date insuranceValidity, Date fitnessValidity,
				String fitnessCertficate, String insurancePaper, boolean status,
				List<Deal> dealList) {
			super();
			this.vehicleId = vehicleId;
			this.registrationNo = registrationNo;
			this.chasisNo = chasisNo;
			this.ownerName = ownerName;
			this.model = model;
			this.vehicleType = vehicleType;
			this.insuranceProvider = insuranceProvider;
			this.insuranceValidity = insuranceValidity;
			this.fitnessValidity = fitnessValidity;
			this.fitnessCertficate = fitnessCertficate;
			this.insurancePaper = insurancePaper;
			this.status = status;
			this.dealList = dealList;
		}

	public Vehicle() {
		super();
	}
	// ****************************end of constructors**************

	/*
	 * getters and setter methods
	 * 
	 */

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}


	
	
	public String getRegistrationNo() {
		return registrationNo;
	}

	
	public Transporter getTransporter() {
		return transporter;
	}


	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public Date getInsuranceValidity() {
		return insuranceValidity;
	}

	public void setInsuranceValidity(Date insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}

	public Date getFitnessValidity() {
		return fitnessValidity;
	}

	public void setFitnessValidity(Date fitnessValidity) {
		this.fitnessValidity = fitnessValidity;
	}

	public String getFitnessCertficate() {
		return fitnessCertficate;
	}

	public void setFitnessCertficate(String fitnessCertficate) {
		this.fitnessCertficate = fitnessCertficate;
	}

	public String getInsurancePaper() {
		return insurancePaper;
	}

	public void setInsurancePaper(String insurancePaper) {
		this.insurancePaper = insurancePaper;
	}

	/*
	 * end of getters and setters
	 */

}
