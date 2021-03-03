package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.DrugManipulation.DrugReservation;
import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.EPrescription;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.Prescription;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.Complaint;
import ISA.Team22.Domain.PharmacyWorkflow.LoyaltyProgram;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends Person{
	
	@Column(name = "penalty",  nullable = false)
	private Integer penalty;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loyaltyProgram_id", referencedColumnName = "id")
	private LoyaltyProgram loyaltyProgram;
	
	@ManyToMany(targetEntity = Drug.class,  cascade = CascadeType.ALL)
	private List<Drug> drugs;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Counseling> counseling;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Prescription> prescription;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DrugReservation> drugReservations;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Examination> examinations;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Complaint> complaints;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EPrescription> ePrescriptions;
	
	public Patient() {
		super();
	}

	public Patient(Integer penalty, LoyaltyProgram loyaltyProgram, List<Drug> drugs,
			List<Counseling> counseling, List<Prescription> prescription, List<DrugReservation> drugReservations,
			List<Examination> examinations, List<Complaint> complaints, List<EPrescription> ePrescriptions) {
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

	public Integer getPenalty() {
		return penalty;
	}

	public void setPenalty(Integer penalty) {
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

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
