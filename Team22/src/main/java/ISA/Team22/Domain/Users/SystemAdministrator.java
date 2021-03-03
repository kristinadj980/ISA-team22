package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.Complaint;

@Entity
public class SystemAdministrator extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(targetEntity = Complaint.class,  cascade = CascadeType.ALL)
	private List<Complaint> complaints;
	
	private Boolean mainAdmin;

	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(Long id, List<Complaint> complaints, Boolean mainAdmin) {
		super();
		this.id = id;
		this.complaints = complaints;
		this.mainAdmin = mainAdmin;
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

	public Boolean getMainAdmin() {
		return mainAdmin;
	}

	public void setMainAdmin(Boolean mainAdmin) {
		this.mainAdmin = mainAdmin;
	}

	
	
	 
}
