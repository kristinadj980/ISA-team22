package ISA.Team22.Domain.DTO;

import java.time.LocalDate;

public class PatientSearchDTO {
	private String name;
	
	private String surname;
	
	private String email;
	
	private String startDate;
	
	private String startTime;
	
	private Long examinationID;

	
	
	public PatientSearchDTO() {
		super();
	}

	public PatientSearchDTO(String name, String surname, String email, String startDate, String startTime,
			Long examinationID) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.startDate = startDate;
		this.startTime = startTime;
		this.examinationID = examinationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getExaminationID() {
		return examinationID;
	}

	public void setExaminationID(Long examinationID) {
		this.examinationID = examinationID;
	}
	
	

}
