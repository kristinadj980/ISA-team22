package domain;

import java.util.List;

public class Pharmacist extends User{

	   private int allGrades;
	   private int numberOfGrades;
	   private Double counselingPrice;
	   
	   private List<BusinessDay> businessDay;
	   //private List<Prescription> prescription;
	   //private List<Counseling> counseling;
	   private Pharmacy pharmacy;
	   private List<AbsenceRequest> absenceRequest;
}
