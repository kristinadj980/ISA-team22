package domain;

import java.util.Date;
import java.util.List;

public class Examination {
	
	private Double price;
	private Date startDate;
	private int duration;
	private ExaminationStatus examinationStatus;
	private String diagnosis;
	private Dermatologist dermatologist;
	private Patient patient;
	private List<Drug> drugs;
	
	public Examination() {
		super();
	}
	public Examination(Double price, Date startDate, int duration, ExaminationStatus examinationStatus,
			String diagnosis, Dermatologist dermatologist, Patient patient, List<Drug> drug) {
		super();
		this.price = price;
		this.startDate = startDate;
		this.duration = duration;
		this.examinationStatus = examinationStatus;
		this.diagnosis = diagnosis;
		this.dermatologist = dermatologist;
		this.patient = patient;
		this.drugs = drug;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
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
	public List<Drug> getDrug() {
		return drugs;
	}
	public void setDrug(List<Drug> drug) {
		this.drugs = drug;
	}
	
}
