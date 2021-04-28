package ISA.Team22.Domain.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExaminationDTO {

	private Long pharmacyID;
	
	private LocalDate startDate;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private String patientInfo;
	
	private Long duration;
	
	private Long examinationID;
	
	private String pharmacyName;
	
	public ExaminationDTO() {}

	public ExaminationDTO(Long pharmacy, LocalDate startDate, LocalTime startTime, LocalTime endTime, String patientInfo) {
		super();
		this.pharmacyID = pharmacy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.patientInfo = patientInfo;
	}
	
	public ExaminationDTO(Long pharmacy, LocalDate startDate, LocalTime startTime, LocalTime endTime,
			Long duration, Long examinationID, String pharmacyName) {
		super();
		this.pharmacyID = pharmacy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.examinationID = examinationID;
		this.pharmacyName = pharmacyName;
	}

	public Long getPharmacyID() {
		return pharmacyID;
	}

	public void setPharmacyID(Long pharmacy) {
		this.pharmacyID = pharmacy;
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

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(String patientInfo) {
		this.patientInfo = patientInfo;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getExaminationID() {
		return examinationID;
	}

	public void setExaminationID(Long examinationID) {
		this.examinationID = examinationID;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	
	
}
