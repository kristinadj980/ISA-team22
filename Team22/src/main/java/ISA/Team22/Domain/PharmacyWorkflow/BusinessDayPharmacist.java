package ISA.Team22.Domain.PharmacyWorkflow;

import java.util.List;

import ISA.Team22.Domain.Users.Pharmacist;

public class BusinessDayPharmacist {

	private Period shift;
	private List<Period> scheduledPeriods;
	private Pharmacist pharmacist;
	
	public BusinessDayPharmacist() {
		super();
	}
	
	public BusinessDayPharmacist(Period shift, List<Period> scheduledPeriods, Pharmacist pharmacist) {
		super();
		this.shift = shift;
		this.scheduledPeriods = scheduledPeriods;
		this.pharmacist = pharmacist;
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

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

}
