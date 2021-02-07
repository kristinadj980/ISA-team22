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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.Prescription;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayPharmacist;

@Entity
public class Pharmacist{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id", unique = true, nullable = false)
	private Person person;
	
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
	
	public Pharmacist(Long id, Person person, Integer allGrades, Integer numberOfGrades, Double counselingPrice,
			List<BusinessDayPharmacist> businessDays, List<Prescription> prescriptions, List<Counseling> counselings,
			Pharmacy pharmacy, List<AbsenceRequestPharmacist> absenceRequests) {
		super();
		this.id = id;
		this.person = person;
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.counselingPrice = counselingPrice;
		this.businessDays = businessDays;
		this.prescriptions = prescriptions;
		this.counselings = counselings;
		this.pharmacy = pharmacy;
		this.absenceRequests = absenceRequests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	public Double getCounselingPrice() {
		return counselingPrice;
	}

	public void setCounselingPrice(Double counselingPrice) {
		this.counselingPrice = counselingPrice;
	}

	public List<BusinessDayPharmacist> getBusinessDays() {
		return businessDays;
	}

	public void setBusinessDays(List<BusinessDayPharmacist> businessDays) {
		this.businessDays = businessDays;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public List<Counseling> getCounselings() {
		return counselings;
	}

	public void setCounselings(List<Counseling> counselings) {
		this.counselings = counselings;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<AbsenceRequestPharmacist> getAbsenceRequests() {
		return absenceRequests;
	}

	public void setAbsenceRequests(List<AbsenceRequestPharmacist> absenceRequests) {
		this.absenceRequests = absenceRequests;
	}

}
