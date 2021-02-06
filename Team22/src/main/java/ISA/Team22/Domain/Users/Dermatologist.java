package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayPharmacist;

@Entity
public class Dermatologist extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "allGrades",  nullable = false)
	private Integer allGrades;
	
	@Column(name = "numberOfGrades",  nullable = false)
	private Integer numberOfGrades;
	
	@OneToMany(mappedBy = "dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BusinessDayDermatologist> businessDays;
	
	@ManyToMany
	@JoinTable(name = "pharmacyDermatologists", 
	joinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
	private List<Pharmacy> pharmacies;
	
	@OneToMany(mappedBy = "dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Examination> examinations;
	
	@OneToMany(mappedBy = "dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AbsenceRequestDermatologist> absenceRequests;
	
	public Dermatologist() {
		super();
	}

	public Dermatologist(Long id, Integer allGrades, Integer numberOfGrades, List<BusinessDayDermatologist> businessDay, List<Pharmacy> pharmacies,
			List<Examination> examinations, List<AbsenceRequestDermatologist> absenceRequest) {
		super();
		this.id = id;
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.businessDays = businessDay;
		this.pharmacies = pharmacies;
		this.examinations = examinations;
		this.absenceRequests = absenceRequest;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAllGrades() {
		return allGrades;
	}

	public void setAllGrades(Integer allGrades) {
		this.allGrades = allGrades;
	}

	public Integer getNumberOfGrades() {
		return numberOfGrades;
	}

	public void setNumberOfGrades(Integer numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}

	public List<BusinessDayDermatologist> getBusinessDay() {
		return businessDays;
	}

	public void setBusinessDay(List<BusinessDayDermatologist> businessDay) {
		this.businessDays = businessDay;
	}

	public List<Pharmacy> getPharmacy() {
		return pharmacies;
	}

	public void setPharmacy(List<Pharmacy> pharmacy) {
		this.pharmacies = pharmacy;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public List<AbsenceRequestDermatologist> getAbsenceRequest() {
		return absenceRequests;
	}

	public void setAbsenceRequest(List<AbsenceRequestDermatologist> absenceRequest) {
		this.absenceRequests = absenceRequest;
	}
	
	
	   
}
