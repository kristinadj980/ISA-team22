package domain;

import java.util.List;

public class Pharmacist extends User{

	private int allGrades;
	private int numberOfGrades;
	private Double counselingPrice;
	private List<BusinessDay> businessDay;
	private List<Prescription> prescription;
	private List<Counseling> counseling;
	private Pharmacy pharmacy;
	private List<AbsenceRequest> absenceRequest;
	
	public Pharmacist() {
		super();
	}
	public Pharmacist(int allGrades, int numberOfGrades, Double counselingPrice, List<BusinessDay> businessDay,
			List<Prescription> prescription, List<Counseling> counseling, Pharmacy pharmacy,
			List<AbsenceRequest> absenceRequest) {
		super();
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.counselingPrice = counselingPrice;
		this.businessDay = businessDay;
		this.prescription = prescription;
		this.counseling = counseling;
		this.pharmacy = pharmacy;
		this.absenceRequest = absenceRequest;
	}
	public int getAllGrades() {
		return allGrades;
	}
	public void setAllGrades(int allGrades) {
		this.allGrades = allGrades;
	}
	public int getNumberOfGrades() {
		return numberOfGrades;
	}
	public void setNumberOfGrades(int numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}
	public Double getCounselingPrice() {
		return counselingPrice;
	}
	public void setCounselingPrice(Double counselingPrice) {
		this.counselingPrice = counselingPrice;
	}
	public List<BusinessDay> getBusinessDay() {
		return businessDay;
	}
	public void setBusinessDay(List<BusinessDay> businessDay) {
		this.businessDay = businessDay;
	}
	public List<Prescription> getPrescription() {
		return prescription;
	}
	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}
	public List<Counseling> getCounseling() {
		return counseling;
	}
	public void setCounseling(List<Counseling> counseling) {
		this.counseling = counseling;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public List<AbsenceRequest> getAbsenceRequest() {
		return absenceRequest;
	}
	public void setAbsenceRequest(List<AbsenceRequest> absenceRequest) {
		this.absenceRequest = absenceRequest;
	}
	   
	   
	   
	   
}
