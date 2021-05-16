package ISA.Team22.Domain.Users;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayDermatologist;

@Entity
@DiscriminatorValue("Dermatologist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dermatologist extends Person {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "allGrades")
	private Integer allGrades;
	
	@Column(name = "numberOfGrades")
	private Integer numberOfGrades;
	
	@OneToMany(mappedBy = "dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BusinessDayDermatologist> businessDays;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pharmacy_dermatologists", joinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
	private List<Pharmacy> pharmacies;
	
	@OneToMany(mappedBy = "dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Examination> examinations;
	
	@OneToMany(mappedBy = "dermatologist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AbsenceRequestDermatologist> absenceRequests;
	
	public Dermatologist() {
		super();
	}
	
	
	public Dermatologist(Long id, String email, String password, String name, String lastName, String contact,
			Address address, Timestamp lastPasswordResetDate, boolean enabled, List<Authority> authorities,
			Boolean firstLogged,  Integer allGrades, Integer numberOfGrades,
			List<BusinessDayDermatologist> businessDays, List<Pharmacy> pharmacies, List<Examination> examinations,
			List<AbsenceRequestDermatologist> absenceRequests) {
		super(id, email, password, name, lastName, contact, address, lastPasswordResetDate, enabled, authorities, firstLogged);
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.businessDays = businessDays;
		this.pharmacies = pharmacies;
		this.examinations = examinations;
		this.absenceRequests = absenceRequests;
	}

	public List<BusinessDayDermatologist> getBusinessDays() {
		return businessDays;
	}

	public void setBusinessDays(List<BusinessDayDermatologist> businessDays) {
		this.businessDays = businessDays;
	}

	public List<Pharmacy> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacy> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public List<AbsenceRequestDermatologist> getAbsenceRequests() {
		return absenceRequests;
	}

	public void setAbsenceRequests(List<AbsenceRequestDermatologist> absenceRequests) {
		this.absenceRequests = absenceRequests;
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

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getEmail();
	}

	


	
	   
}
