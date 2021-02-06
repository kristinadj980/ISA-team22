package ISA.Team22.Domain.Users;

import java.util.List;

import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.Prescription;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayPharmacist;

public class Pharmacist extends User{

	private Integer allGrades;
	private Integer numberOfGrades;
	private Double counselingPrice;
	private List<BusinessDayPharmacist> businessDays;
	private List<Prescription> prescriptions;
	private List<Counseling> counselings;
	private Pharmacy pharmacy;
	private List<AbsenceRequestPharmacist> absenceRequests;
	
	public Pharmacist() {
		super();
	}
	
	public Pharmacist(Integer allGrades, Integer numberOfGrades, Double counselingPrice, List<BusinessDayPharmacist> businessDay,
			List<Prescription> prescription, List<Counseling> counseling, Pharmacy pharmacy,
			List<AbsenceRequestPharmacist> absenceRequest) {
		super();
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.counselingPrice = counselingPrice;
		this.businessDays = businessDay;
		this.prescriptions = prescription;
		this.counselings = counseling;
		this.pharmacy = pharmacy;
		this.absenceRequests = absenceRequest;
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
	public List<BusinessDayPharmacist> getBusinessDay() {
		return businessDays;
	}
	public void setBusinessDay(List<BusinessDayPharmacist> businessDay) {
		this.businessDays = businessDay;
	}
	public List<Prescription> getPrescription() {
		return prescriptions;
	}
	public void setPrescription(List<Prescription> prescription) {
		this.prescriptions = prescription;
	}
	public List<Counseling> getCounseling() {
		return counselings;
	}
	public void setCounseling(List<Counseling> counseling) {
		this.counselings = counseling;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public List<AbsenceRequestPharmacist> getAbsenceRequest() {
		return absenceRequests;
	}
	public void setAbsenceRequest(List<AbsenceRequestPharmacist> absenceRequest) {
		this.absenceRequests = absenceRequest;
	}
	   
	   
	   
	   
}
