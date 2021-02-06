package ISA.Team22.Domain.Users;

import java.util.List;

import ISA.Team22.Domain.PharmacyWorkflow.Complaint;

public class SystemAdministrator extends User {

	private List<Complaint> complaints;

	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(List<Complaint> complaints) {
		super();
		this.complaints = complaints;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	 
	
	 
}
