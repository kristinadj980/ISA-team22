package domain;

import java.util.List;

public class Patient extends User {
	private int penalty;
	private LoyaltyProgram loyaltyProgram;
	private List<Drug> drugs;
	private List<Counseling> counseling;
	private List<Prescription> prescription;
	//private DrugReservation[] drugReservation;
	private List<Examination> examinations;
	//private Complaints[] complaints;
	//private EPrescription[] ePrescription;
}
