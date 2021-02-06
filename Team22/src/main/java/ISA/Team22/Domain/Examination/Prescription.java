package ISA.Team22.Domain.Examination;

import java.util.Date;
import java.util.List;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Pharmacist;

public class Prescription {
	private Date prescriptionDate;
	private int amountOfDrug;
	private Pharmacist pharmacist;
	private Patient patient;
	private List<Drug> drugs;
    private double durationOfTherapy;
    
	public Prescription() {
		super();
	}
	public Prescription(Date prescriptionDate, int amountOfDrug, Pharmacist pharmacist, Patient patient,
			List<Drug> drugs, double durationOfTherapy) {
		super();
		this.prescriptionDate = prescriptionDate;
		this.amountOfDrug = amountOfDrug;
		this.pharmacist = pharmacist;
		this.patient = patient;
		this.drugs = drugs;
		this.durationOfTherapy = durationOfTherapy;
	}
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public int getAmountOfDrug() {
		return amountOfDrug;
	}
	public void setAmountOfDrug(int amountOfDrug) {
		this.amountOfDrug = amountOfDrug;
	}
	public Pharmacist getPharmacist() {
		return pharmacist;
	}
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Drug> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}
	public double getDurationOfTherapy() {
		return durationOfTherapy;
	}
	public void setDurationOfTherapy(double durationOfTherapy) {
		this.durationOfTherapy = durationOfTherapy;
	}
	 
}
