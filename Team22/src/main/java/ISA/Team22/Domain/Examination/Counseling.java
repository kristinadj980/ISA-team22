package ISA.Team22.Domain.Examination;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Pharmacist;

@Entity
public class Counseling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "startDate",  nullable = false)
	private Date startDate;
	
	@Column(name = "diagnosis",  nullable = false)
	private String diagnosis;
	
	private Pharmacist pharmacist;
	private Patient patient;
	private ExaminationStatus counselingStatus;
	
	public Counseling() {
		super();
	}
	public Counseling(Long id, Date startDate, String diagnosis, Pharmacist pharmacist, Patient patient,ExaminationStatus counselingStatus) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.diagnosis = diagnosis;
		this.pharmacist = pharmacist;
		this.patient = patient;
		this.counselingStatus = counselingStatus;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
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
	public ExaminationStatus getCounselingStatus() {
		return counselingStatus;
	}
	public void setCounselingStatus(ExaminationStatus counselingStatus) {
		this.counselingStatus = counselingStatus;
	}
	
	
	
}
