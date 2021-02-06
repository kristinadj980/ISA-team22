package ISA.Team22.Domain.PharmacyWorkflow;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Users.Dermatologist;

@Entity
public class BusinessDayDermatologist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Period shift;
	private List<Period> scheduledPeriods;
	private Dermatologist dermatologist;
	
	@Column(name = "pharmacyId",  nullable = false)
	private Long pharmacyId;
	
	public BusinessDayDermatologist() {
		super();
	}

	public BusinessDayDermatologist(Long id, Period shift, List<Period> scheduledPeriods, Dermatologist dermatologist,
			Long pharmacyId) {
		super();
		this.id = id;
		this.shift = shift;
		this.scheduledPeriods = scheduledPeriods;
		this.dermatologist = dermatologist;
		this.pharmacyId = pharmacyId;
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

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	
	
	
}
