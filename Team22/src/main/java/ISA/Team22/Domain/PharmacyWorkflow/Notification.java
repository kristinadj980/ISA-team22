package ISA.Team22.Domain.PharmacyWorkflow;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.Pharmacy.Pharmacy;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Drug drug;
	private Pharmacy pharmacy;
	
	public Notification() {
		super();
	}

	public Notification(Long id, Drug drug, Pharmacy pharmacy) {
		super();
		this.id = id;
		this.drug = drug;
		this.pharmacy = pharmacy;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
    
	
	
    
}
