package ISA.Team22.Domain.Pharmacy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ISA.Team22.Domain.DTO.DrugDTO;

@Entity
public class PharmacyInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "pharmacyInventory")
	private Pharmacy pharmacy;
	
	private List<DrugDTO> drugDTOs;
	
	public PharmacyInventory() {
		super();
	}

	public PharmacyInventory(Long id, Pharmacy pharmacy, List<DrugDTO> drugDTOs) {
		super();
		this.id = id;
		this.pharmacy = pharmacy;
		this.drugDTOs = drugDTOs;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
