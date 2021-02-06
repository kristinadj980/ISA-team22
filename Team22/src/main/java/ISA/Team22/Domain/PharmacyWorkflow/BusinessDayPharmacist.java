package ISA.Team22.Domain.PharmacyWorkflow;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Users.Pharmacist;

@Entity
public class BusinessDayPharmacist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Period shift;
	private List<Period> scheduledPeriods;
	private Pharmacist pharmacist;
	
	public BusinessDayPharmacist() {
		super();
	}
	
	public BusinessDayPharmacist(Long id, Period shift, List<Period> scheduledPeriods, Pharmacist pharmacist) {
		super();
		this.id = id;
		this.shift = shift;
		this.scheduledPeriods = scheduledPeriods;
		this.pharmacist = pharmacist;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
