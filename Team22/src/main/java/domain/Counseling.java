package domain;

import java.util.Date;

public class Counseling {
	private Date startDate;
	private String diagnosis;
	public Pharmacist pharmacist;
	public Patient patient;
	
	public Counseling() {
		super();
	}
	public Counseling(Date startDate, String diagnosis, Pharmacist pharmacist, Patient patient) {
		super();
		this.startDate = startDate;
		this.diagnosis = diagnosis;
		this.pharmacist = pharmacist;
		this.patient = patient;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Pharmacist getPharmacist() {
		return pharmacist;
	}
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
