package ISA.Team22.Domain.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CounselingDTO {
	
	private Long counselingId;
	
	private LocalDate startDate;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private String patientInfo;

	
	public CounselingDTO() {
		super();
	}

	
	public CounselingDTO(Long counselingId, LocalDate startDate, LocalTime startTime, LocalTime endTime, String patientInfo) {
		super();
		this.counselingId = counselingId;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.patientInfo = patientInfo;
	}



	public CounselingDTO(LocalDate startDate, LocalTime startTime, LocalTime endTime, String patientInfo) {
		super();
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.patientInfo = patientInfo;
	}

	public Long getCounselingId() {
		return counselingId;
	}


	public void setCounselingId(Long counselingId) {
		this.counselingId = counselingId;
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
	
	
}
