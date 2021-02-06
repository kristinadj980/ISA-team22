package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.Prescription;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayPharmacist;

@Entity
public class Pharmacist extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "allGrades",  nullable = false)
	private Integer allGrades;
	
	@Column(name = "numberOfGrades",  nullable = false)
	private Integer numberOfGrades;
	
	@Column(name = "counselingPrice",  nullable = false)
	private Double counselingPrice;
	
	@OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BusinessDayPharmacist> businessDays;
	
	@OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Prescription> prescriptions;
	
	@OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Counseling> counselings;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy pharmacy;
	
	@OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AbsenceRequestPharmacist> absenceRequests;
	
	public Pharmacist() {
		super();
	}
	
	public Pharmacist(Long id, Integer allGrades, Integer numberOfGrades, Double counselingPrice, List<BusinessDayPharmacist> businessDay,
			List<Prescription> prescription, List<Counseling> counseling, Pharmacy pharmacy,
			List<AbsenceRequestPharmacist> absenceRequest) {
		super();
		this.id = id;
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.counselingPrice = counselingPrice;
		this.businessDays = businessDay;
		this.prescriptions = prescription;
		this.counselings = counseling;
		this.pharmacy = pharmacy;
		this.absenceRequests = absenceRequest;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
