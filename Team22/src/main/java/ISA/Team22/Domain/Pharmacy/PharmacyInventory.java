package ISA.Team22.Domain.Pharmacy;

import java.util.List;

import ISA.Team22.Domain.DTO.DrugDTO;

public class PharmacyInventory {
	
	private Pharmacy pharmacy;
	private List<DrugDTO> drugDTOs;
	
	public PharmacyInventory() {
		super();
	}

	public PharmacyInventory(Pharmacy pharmacy, List<DrugDTO> drugDTOs) {
		super();
		this.pharmacy = pharmacy;
		this.drugDTOs = drugDTOs;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<DrugDTO> getDrugDTOs() {
		return drugDTOs;
	}

	public void setDrugDTOs(List<DrugDTO> drugDTOs) {
		this.drugDTOs = drugDTOs;
	}

	

}
