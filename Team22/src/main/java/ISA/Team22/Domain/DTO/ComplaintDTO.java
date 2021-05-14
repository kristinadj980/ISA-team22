package ISA.Team22.Domain.DTO;

public class ComplaintDTO {
	
	private String description;
	private String answer;
	private Long roleId;
	private Boolean isAnswered;
	private Long patientId;
	
	public ComplaintDTO() {
		super();
	}

	public ComplaintDTO(String description, String answer, Long roleId, Boolean isAnswered, Long patientId) {
		super();
		this.description = description;
		this.answer = answer;
		this.roleId = roleId;
		this.isAnswered = isAnswered;
		this.patientId = patientId;
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	

	
}
