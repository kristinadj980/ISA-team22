package ISA.Team22.Domain.Examination;

import java.util.Date;

import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Pharmacist;

public class Counseling {
	private Date startDate;
	private String diagnosis;
	private Pharmacist pharmacist;
	private Patient patient;
	private ExaminationStatus counselingStatus;
	
	public Counseling() {
		super();
	}
	public Counseling(Date startDate, String diagnosis, Pharmacist pharmacist, Patient patient,ExaminationStatus counselingStatus) {
		super();
		this.startDate = startDate;
		this.diagnosis = diagnosis;
		this.pharmacist = pharmacist;
		this.patient = patient;
		this.counselingStatus = counselingStatus;
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
