package ISA.Team22.Domain.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Users.Patient;

public class ExaminationDTO {

	private String pharmacy;
	
	private LocalDate startDate;
	
	private LocalTime startTime;
	
	private Integer duration;
	
	private ExaminationStatus examinationStatus;
	
	private DermatologistDTO dermatologist;
	
	private Patient patient;
	
	public ExaminationDTO() {}
	
	
	public ExaminationDTO( String pharmacy, LocalDate startDate, LocalTime startTime, Integer duration,
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
	
	public ExaminationDTO(LocalDate startDate, LocalTime startTime) {
		super();
		this.startDate = startDate;
		this.startTime = startTime;
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
