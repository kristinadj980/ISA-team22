package domain;

public class DrugDTO {
	private double price;
	private Period period;
	public Drug drug;
	
	public DrugDTO() {
		super();
	}
	public DrugDTO(double price, Period period, Drug drug) {
		super();
		this.price = price;
		this.period = period;
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
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
}
