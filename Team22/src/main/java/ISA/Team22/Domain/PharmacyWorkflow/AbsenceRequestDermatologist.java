package ISA.Team22.Domain.PharmacyWorkflow;

import ISA.Team22.Domain.Pharmacy.OfferStatus;
import ISA.Team22.Domain.Users.Dermatologist;

public class AbsenceRequestDermatologist {

	private Period period;
	private VacationType vacationType;
	private String description;
	private OfferStatus status;
	private Dermatologist dermatologist;
	
	public AbsenceRequestDermatologist() {
		super();
	}

	public AbsenceRequestDermatologist(Period period, VacationType vacationType, String description, OfferStatus status, Dermatologist dermatologist) {
		super();
		this.period = period;
		this.vacationType = vacationType;
		this.description = description;
		this.status = status;
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

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}
	  
	
	   
}
