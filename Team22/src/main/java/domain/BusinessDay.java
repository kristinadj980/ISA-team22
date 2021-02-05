package domain;

import java.util.List;

public class BusinessDay {

	private Period shift;
	private List<Period> scheduledPeriods;
	private Pharmacist pharmacist;
	private Dermatologist dermatologist;
	
	public BusinessDay() {
		super();
	}
	
	public BusinessDay(Period shift, List<Period> scheduledPeriods, Pharmacist pharmacist,
			Dermatologist dermatologist) {
		super();
		this.shift = shift;
		this.scheduledPeriods = scheduledPeriods;
		this.pharmacist = pharmacist;
		this.dermatologist = dermatologist;
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

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}
	
	
	
}
