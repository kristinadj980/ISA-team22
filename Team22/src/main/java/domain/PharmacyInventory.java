package domain;

import java.util.List;

public class PharmacyInventory {
	
	   private int drugAmount;
	   private Double price;
	   private Pharmacy pharmacy;
	   private List<DrugDTO> drugDTOs;
	
	   public PharmacyInventory() {
		super();
	   }

	   public PharmacyInventory(int drugAmount, Double price, Pharmacy pharmacy, List<DrugDTO> drugDTOs) {
		super();
		this.drugAmount = drugAmount;
		this.price = price;
		this.pharmacy = pharmacy;
		this.drugDTOs = drugDTOs;
	}
	
	  public int getDrugAmount() {
		return drugAmount;
	}

	  public void setDrugAmount(int drugAmount) {
		this.drugAmount = drugAmount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
