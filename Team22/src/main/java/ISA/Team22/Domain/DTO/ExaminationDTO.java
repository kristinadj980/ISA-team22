package ISA.Team22.Domain.DTO;

import java.time.LocalTime;

public class ExaminationDTO {

	private Long pharmacyID;
	
	private String startDate;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private String patientInfo;
	
	public ExaminationDTO() {}

	public ExaminationDTO(Long pharmacy, String startDate, LocalTime startTime, LocalTime endTime, String patientInfo) {
		super();
		this.pharmacyID = pharmacy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.patientInfo = patientInfo;
	}

	public Long getPharmacyID() {
		return pharmacyID;
	}

	public void setPharmacyID(Long pharmacy) {
		this.pharmacyID = pharmacy;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
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
	
}
