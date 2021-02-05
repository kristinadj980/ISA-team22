package domain;

public class AbsenceRequest {

	private Period period;
	private VacationType vacationType;
	private String description;
	private OfferStatus status;
	private Pharmacist pharmacist;
	private Dermatologist dermatologist;
	
	public AbsenceRequest() {
		super();
	}

	public AbsenceRequest(Period period, VacationType vacationType, String description, OfferStatus status,
			Pharmacist pharmacist, Dermatologist dermatologist) {
		super();
		this.period = period;
		this.vacationType = vacationType;
		this.description = description;
		this.status = status;
		this.pharmacist = pharmacist;
		this.dermatologist = dermatologist;
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

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}
	  
	
	   
}
