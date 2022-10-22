package com.example.dsm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Distributor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int distributorId;
	private String distributorName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "distributorId")
	private Contact distributorContact;
	private String distributorService;

	public int getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public Contact getDistributorContact() {
		return distributorContact;
	}

	public void setDistributorContact(Contact distributorContact) {
		this.distributorContact = distributorContact;
	}

	public String getDistributorService() {
		return distributorService;
	}

	public void setDistributorService(String distributorService) {
		this.distributorService = distributorService;
	}

	@Override
	public String toString() {
		return "Distributor [distributorId=" + distributorId + ", distributorName=" + distributorName
				+ ", distributorContact=" + distributorContact + ", distributorService=" + distributorService + "]";
	}
	

}
