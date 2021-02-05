package domain;

public class Notification {

	private Drug drug;
	private Pharmacy pharmacy;
	
	public Notification() {
		super();
	}

	public Notification(Drug drug, Pharmacy pharmacy) {
		super();
		this.drug = drug;
		this.pharmacy = pharmacy;
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
