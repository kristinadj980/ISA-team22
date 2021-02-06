package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.PharmacyWorkflow.Complaint;

@Entity
public class SystemAdministrator extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<Complaint> complaints;

	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(Long id, List<Complaint> complaints) {
		super();
		this.id = id;
		this.complaints = complaints;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	 
	
	 
}
