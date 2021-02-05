package domain;

import java.util.Date;

public class Complaints {
	
	private String description;
	private String answer;
	private Date complaintDate;
	private long roleId;
	private Patient patient;
	
	public Complaints() {
		super();
	}

	public Complaints(String description, String answer, Date complaintDate, long roleId, Patient patient) {
		super();
		this.description = description;
		this.answer = answer;
		this.complaintDate = complaintDate;
		this.roleId = roleId;
		this.patient = patient;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	   
}
