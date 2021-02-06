package ISA.Team22.Domain.PharmacyWorkflow;

import ISA.Team22.Domain.Pharmacy.OfferStatus;
import ISA.Team22.Domain.Users.Pharmacist;

public class AbsenceRequestPharmacist {
	
	private Period period;
	private VacationType vacationType;
	private String description;
	private OfferStatus status;
	private Pharmacist pharmacist;
	
	public AbsenceRequestPharmacist() {
		super();
	}

	public AbsenceRequestPharmacist(Period period, VacationType vacationType, String description, OfferStatus status,
			Pharmacist pharmacist) {
		super();
		this.period = period;
		this.vacationType = vacationType;
		this.description = description;
		this.status = status;
		this.pharmacist = pharmacist;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public VacationType getVacationType() {
		return vacationType;
	}

	public void setVacationType(VacationType vacationType) {
		this.vacationType = vacationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OfferStatus getStatus() {
		return status;
	}

	public void setStatus(OfferStatus status) {
		this.status = status;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}
	
	
}
