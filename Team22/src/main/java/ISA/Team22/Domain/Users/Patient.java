package ISA.Team22.Domain.Users;

import java.util.List;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.DrugManipulation.DrugReservation;
import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.EPrescription;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.Prescription;
import ISA.Team22.Domain.PharmacyWorkflow.Complaint;
import ISA.Team22.Domain.PharmacyWorkflow.LoyaltyProgram;

public class Patient extends User {
	
	private int penalty;
	private LoyaltyProgram loyaltyProgram;
	private List<Drug> drugs;
	private List<Counseling> counseling;
	private List<Prescription> prescription;
	private List<DrugReservation> drugReservations;
	private List<Examination> examinations;
	private List<Complaint> complaints;
	private List<EPrescription> ePrescriptions;
	
	public Patient() {
		super();
	}

	public Patient(int penalty, LoyaltyProgram loyaltyProgram, List<Drug> drugs, List<Counseling> counseling,
			List<Prescription> prescription, List<DrugReservation> drugReservations, List<Examination> examinations,
			List<Complaint> complaints, List<EPrescription> ePrescriptions) {
		super();
		this.penalty = penalty;
		this.loyaltyProgram = loyaltyProgram;
		this.drugs = drugs;
		this.counseling = counseling;
		this.prescription = prescription;
		this.drugReservations = drugReservations;
		this.examinations = examinations;
		this.complaints = complaints;
		this.ePrescriptions = ePrescriptions;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public LoyaltyProgram getLoyaltyProgram() {
		return loyaltyProgram;
	}

	public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
		this.loyaltyProgram = loyaltyProgram;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public List<Counseling> getCounseling() {
		return counseling;
	}

	public void setCounseling(List<Counseling> counseling) {
		this.counseling = counseling;
	}

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}

	public List<DrugReservation> getDrugReservations() {
		return drugReservations;
	}

	public void setDrugReservations(List<DrugReservation> drugReservations) {
		this.drugReservations = drugReservations;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public List<EPrescription> getePrescriptions() {
		return ePrescriptions;
	}

	public void setePrescriptions(List<EPrescription> ePrescriptions) {
		this.ePrescriptions = ePrescriptions;
	}
	
	
	
}
