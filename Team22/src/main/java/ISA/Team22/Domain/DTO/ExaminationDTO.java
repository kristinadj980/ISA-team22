package ISA.Team22.Domain.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Users.Patient;

public class ExaminationDTO {

	private String pharmacy;
	
	private String startDate;
	
	private String startTime;
	
	private String endTime;
	
	private Integer duration;
	
	private ExaminationStatus examinationStatus;
	
	private DermatologistDTO dermatologist;
	
	private Patient patient;
	
	public ExaminationDTO() {}
	
	
	public ExaminationDTO( String pharmacy, String startDate, String startTime, Integer duration,
			ExaminationStatus examinationStatus, DermatologistDTO dermatologist, Patient patient) {
		super();
		this.pharmacy = pharmacy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
		this.examinationStatus = examinationStatus;
		this.dermatologist = dermatologist;
		this.patient = patient;
	}
	
	public ExaminationDTO(String startDate, String startTime, String endTime) {
		super();
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	
	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public DermatologistDTO getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(DermatologistDTO dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	
}
