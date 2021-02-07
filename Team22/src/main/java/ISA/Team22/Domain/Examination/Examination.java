package ISA.Team22.Domain.Examination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Patient;

@Entity
public class Examination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price",  nullable = false)
	private Double price;
	
	@Column(name = "startDate",  nullable = false)
	private LocalDate startDate;
	
	@Column(name = "startTime",  nullable = false)
	private LocalTime startTime;
	
	@Column(name = "duration",  nullable = false)
	private Integer duration;
	
	@Enumerated(EnumType.ORDINAL)
	private ExaminationStatus examinationStatus;
	
	@Column(name = "diagnosis",  nullable = false)
	private String diagnosis;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Dermatologist dermatologist;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pharmacy_id", referencedColumnName = "id", nullable = false)
	private Pharmacy pharmacy;
	
	@ManyToMany(targetEntity = Drug.class,  cascade = CascadeType.ALL)
	private List<Drug> drugs;
	
	public Examination() {
		super();
	}

	public Examination(Long id, Double price, LocalDate startDate, LocalTime startTime, Integer duration,
			ExaminationStatus examinationStatus, String diagnosis, Dermatologist dermatologist, Patient patient,
			Pharmacy pharmacy, List<Drug> drugs) {
		super();
		this.id = id;
		this.price = price;
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
		this.examinationStatus = examinationStatus;
		this.diagnosis = diagnosis;
		this.dermatologist = dermatologist;
		this.patient = patient;
		this.pharmacy = pharmacy;
		this.drugs = drugs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ExaminationStatus getExaminationStatus() {
		return examinationStatus;
	}

	public void setExaminationStatus(ExaminationStatus examinationStatus) {
		this.examinationStatus = examinationStatus;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	
}
