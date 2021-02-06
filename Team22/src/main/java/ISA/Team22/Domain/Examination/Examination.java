package ISA.Team22.Domain.Examination;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
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
	private Date startDate;
	
	@Column(name = "duration",  nullable = false)
	private Integer duration;
	
	private ExaminationStatus examinationStatus;
	
	@Column(name = "diagnosis",  nullable = false)
	private String diagnosis;
	
	private Dermatologist dermatologist;
	
	private Patient patient;
	
	private Pharmacy pharmacy;
	
	private List<Drug> drugs;
	
	public Examination() {
		super();
	}
	public Examination(Long id, Double price, Date startDate, Integer duration, ExaminationStatus examinationStatus,
			String diagnosis, Dermatologist dermatologist, Patient patient, List<Drug> drug,Pharmacy pharmacy) {
		super();
		this.id = id;
		this.price = price;
		this.startDate = startDate;
		this.duration = duration;
		this.examinationStatus = examinationStatus;
		this.diagnosis = diagnosis;
		this.dermatologist = dermatologist;
		this.patient = patient;
		this.drugs = drug;
		this.pharmacy = pharmacy;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
