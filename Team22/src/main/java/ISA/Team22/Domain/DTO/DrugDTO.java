package ISA.Team22.Domain.DTO;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.PharmacyWorkflow.Period;

public class DrugDTO {
	private double price;
	private Period period;
	 private int drugAmount;
	public Drug drug;
	
	public DrugDTO() {
		super();
	}

	public DrugDTO(double price, Period period, int drugAmount, Drug drug) {
		super();
		this.price = price;
		this.period = period;
		this.drugAmount = drugAmount;
		this.drug = drug;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public int getDrugAmount() {
		return drugAmount;
	}

	public void setDrugAmount(int drugAmount) {
		this.drugAmount = drugAmount;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	
}
