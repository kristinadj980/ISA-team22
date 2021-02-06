package ISA.Team22.Domain.DrugManipulation;

import java.util.Date;
import java.util.List;

import ISA.Team22.Domain.Users.Patient;

public class DrugReservation {
	
	private long resevationId;
	private DrugStatus status;
	private Date dueDate;	   
	private Patient patient;
	private long pharmacyId;
	private long drugId;
	   
	public DrugReservation() {
		super();
	}

	public DrugReservation(long resevationId, DrugStatus status, Date dueDate, Patient patient, long pharmacyId,
			long drugId) {
		super();
		this.resevationId = resevationId;
		this.status = status;
		this.dueDate = dueDate;
		this.patient = patient;
		this.pharmacyId = pharmacyId;
		this.drugId = drugId;
	}

	public long getResevationId() {
		return resevationId;
	}

	public void setResevationId(long resevationId) {
		this.resevationId = resevationId;
	}

	public DrugStatus getStatus() {
		return status;
	}

	public void setStatus(DrugStatus status) {
		this.status = status;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}
	   
	
	   

}
