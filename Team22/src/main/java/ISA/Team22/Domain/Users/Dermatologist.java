package ISA.Team22.Domain.Users;

import java.util.List;

import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayPharmacist;

public class Dermatologist  {

	private Integer allGrades;
	private Integer numberOfGrades;
	private List<BusinessDayDermatologist> businessDays;
	private List<Pharmacy> pharmacies;
	private List<Examination> examinations;
	private List<AbsenceRequestDermatologist> absenceRequests;
	
	public Dermatologist() {
		super();
	}

	public Dermatologist(Integer allGrades, Integer numberOfGrades, List<BusinessDayDermatologist> businessDay, List<Pharmacy> pharmacies,
			List<Examination> examinations, List<AbsenceRequestDermatologist> absenceRequest) {
		super();
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.businessDays = businessDay;
		this.pharmacies = pharmacies;
		this.examinations = examinations;
		this.absenceRequests = absenceRequest;
	}

	public Integer getAllGrades() {
		return allGrades;
	}

	public void setAllGrades(Integer allGrades) {
		this.allGrades = allGrades;
	}

	public Integer getNumberOfGrades() {
		return numberOfGrades;
	}

	public void setNumberOfGrades(Integer numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}

	public List<BusinessDayDermatologist> getBusinessDay() {
		return businessDays;
	}

	public void setBusinessDay(List<BusinessDayDermatologist> businessDay) {
		this.businessDays = businessDay;
	}

	public List<Pharmacy> getPharmacy() {
		return pharmacies;
	}

	public void setPharmacy(List<Pharmacy> pharmacy) {
		this.pharmacies = pharmacy;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public List<AbsenceRequestDermatologist> getAbsenceRequest() {
		return absenceRequests;
	}

	public void setAbsenceRequest(List<AbsenceRequestDermatologist> absenceRequest) {
		this.absenceRequests = absenceRequest;
	}
	
	
	   
}
