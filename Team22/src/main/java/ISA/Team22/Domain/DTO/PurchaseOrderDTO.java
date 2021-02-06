package ISA.Team22.Domain.DTO;

import ISA.Team22.Domain.DrugManipulation.Drug;

public class PurchaseOrderDTO {
	private int amount;
	private Drug drug;
	
	public PurchaseOrderDTO() {
		super();
	}
	public PurchaseOrderDTO(int amount, Drug drug) {
		super();
		this.amount = amount;
		this.drug = drug;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	 
}
