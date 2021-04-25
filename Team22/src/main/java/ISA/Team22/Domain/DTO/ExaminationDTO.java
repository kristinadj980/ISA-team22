package ISA.Team22.Domain.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Users.Patient;

public class ExaminationDTO {

	private Long pharmacy;
	
	private String startDate;
	
	private String startTime;
	
	private String endTime;
	
	private String patientInfo;
	
	public ExaminationDTO() {}

	public ExaminationDTO(Long pharmacy, String startDate, String startTime, String endTime, String patientInfo) {
		super();
		this.pharmacy = pharmacy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.patientInfo = patientInfo;
	}

	public Long getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Long pharmacy) {
		this.pharmacy = pharmacy;
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

	public String getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(String patientInfo) {
		this.patientInfo = patientInfo;
	}
	
}
