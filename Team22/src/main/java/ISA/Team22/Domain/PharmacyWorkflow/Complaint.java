package ISA.Team22.Domain.PharmacyWorkflow;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Users.Patient;

@Entity
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description",  nullable = false)
	private String description;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "complaintDate",  nullable = false)
	private Date complaintDate;
	
	@Column(name = "roleId",  nullable = false)
	private Long roleId;
	
	private Patient patient;
	
	@Column(name = "isAnswered",  nullable = false)
	private Boolean isAnswered;
	
	public Complaint() {
		super();
	}

	public Complaint(Long id, String description, String answer, Date complaintDate, Long roleId, Patient patient, Boolean isAnswerd) {
		super();
		this.id = id;
		this.description = description;
		this.answer = answer;
		this.complaintDate = complaintDate;
		this.roleId = roleId;
		this.patient = patient;
		this.isAnswered = isAnswerd;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	
	   
}
