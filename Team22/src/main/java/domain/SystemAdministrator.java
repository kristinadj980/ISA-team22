package domain;

import java.util.List;

public class SystemAdministrator extends User {

	private List<Complaints> complaints;

	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(List<Complaints> complaints) {
		super();
		this.complaints = complaints;
	}

	public List<Complaints> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaints> complaints) {
		this.complaints = complaints;
	}
	 
	
	 
}
