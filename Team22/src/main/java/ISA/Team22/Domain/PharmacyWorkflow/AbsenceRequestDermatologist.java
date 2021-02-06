package ISA.Team22.Domain.PharmacyWorkflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Pharmacy.OfferStatus;
import ISA.Team22.Domain.Users.Dermatologist;

@Entity
public class AbsenceRequestDermatologist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Period period;
	private VacationType vacationType;
	

	@Column(name = "description",  nullable = false)
	private String description;
	
	private OfferStatus status;
	private Dermatologist dermatologist;
	
	public AbsenceRequestDermatologist() {
		super();
	}

	public AbsenceRequestDermatologist(Long id, Period period, VacationType vacationType, String description, OfferStatus status, Dermatologist dermatologist) {
		super();
		this.id = id;
		this.period = period;
		this.vacationType = vacationType;
		this.description = description;
		this.status = status;
		this.dermatologist = dermatologist;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
