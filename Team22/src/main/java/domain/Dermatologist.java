package domain;

import java.util.List;

public class Dermatologist  {

	private int allGrades;
	private int numberOfGrades;
	private List<BusinessDay> businessDay;
	private List<Pharmacy> pharmacy;
	private List<Examination> examinations;
	private List<AbsenceRequest> absenceRequest;
	
	public Dermatologist() {
		super();
	}

	public Dermatologist(int allGrades, int numberOfGrades, List<BusinessDay> businessDay, List<Pharmacy> pharmacy,
			List<Examination> examinations, List<AbsenceRequest> absenceRequest) {
		super();
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.businessDay = businessDay;
		this.pharmacy = pharmacy;
		this.examinations = examinations;
		this.absenceRequest = absenceRequest;
	}

	public int getAllGrades() {
		return allGrades;
	}

	public void setAllGrades(int allGrades) {
		this.allGrades = allGrades;
	}

	public int getNumberOfGrades() {
		return numberOfGrades;
	}

	public void setNumberOfGrades(int numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}

	public List<BusinessDay> getBusinessDay() {
		return businessDay;
	}

	public void setBusinessDay(List<BusinessDay> businessDay) {
		this.businessDay = businessDay;
	}

	public List<Pharmacy> getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(List<Pharmacy> pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public List<AbsenceRequest> getAbsenceRequest() {
		return absenceRequest;
	}

	public void setAbsenceRequest(List<AbsenceRequest> absenceRequest) {
		this.absenceRequest = absenceRequest;
	}
	
	
	   
}
