package ISA.Team22.Domain.Examination;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Pharmacist;

@Entity
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prescriptionDate",  nullable = false)
	private Date prescriptionDate;
	
	@Column(name = "amountOfDrug",  nullable = false)
	private Integer amountOfDrug;
	
	@Column(name = "durationOfTherapy",  nullable = false)
    private Double durationOfTherapy;
	
	
	private Pharmacist pharmacist;
	private Patient patient;
	private List<Drug> drugs;
    
	public Prescription() {
		super();
	}
	public Prescription(Long id, Date prescriptionDate, Integer amountOfDrug, Pharmacist pharmacist, Patient patient,
			List<Drug> drugs, Double durationOfTherapy) {
		super();
		this.id = id;
		this.prescriptionDate = prescriptionDate;
		this.amountOfDrug = amountOfDrug;
		this.pharmacist = pharmacist;
		this.patient = patient;
		this.drugs = drugs;
		this.durationOfTherapy = durationOfTherapy;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public Integer getAmountOfDrug() {
		return amountOfDrug;
	}
	public void setAmountOfDrug(Integer amountOfDrug) {
		this.amountOfDrug = amountOfDrug;
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
	public List<Drug> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}
	public Double getDurationOfTherapy() {
		return durationOfTherapy;
	}
	public void setDurationOfTherapy(Double durationOfTherapy) {
		this.durationOfTherapy = durationOfTherapy;
	}
	 
}
