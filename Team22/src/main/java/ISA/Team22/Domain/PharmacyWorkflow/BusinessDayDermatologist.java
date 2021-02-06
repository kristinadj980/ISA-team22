package ISA.Team22.Domain.PharmacyWorkflow;

import java.util.List;

import ISA.Team22.Domain.Users.Dermatologist;

public class BusinessDayDermatologist {
	
	private Period shift;
	private List<Period> scheduledPeriods;
	private Dermatologist dermatologist;
	private long pharmacyId;
	
	public BusinessDayDermatologist() {
		super();
	}

	public BusinessDayDermatologist(Period shift, List<Period> scheduledPeriods, Dermatologist dermatologist,
			long pharmacyId) {
		super();
		this.shift = shift;
		this.scheduledPeriods = scheduledPeriods;
		this.dermatologist = dermatologist;
		this.pharmacyId = pharmacyId;
	}

	public Period getShift() {
		return shift;
	}

	public void setShift(Period shift) {
		this.shift = shift;
	}

	public List<Period> getScheduledPeriods() {
		return scheduledPeriods;
	}

	public void setScheduledPeriods(List<Period> scheduledPeriods) {
		this.scheduledPeriods = scheduledPeriods;
	}

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

	public long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	
	
	
}
