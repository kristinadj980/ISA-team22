package ISA.Team22.Domain.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.PharmacyWorkflow.Period;


@Entity
public class DrugDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "price", nullable = false)
	private Double price;
	
	
	private Period period;
	
	@Column(name = "drugAmount", nullable = false)
	private Integer drugAmount;
	
	
	private Drug drug;
	
	public DrugDTO() {
		super();
	}

	public DrugDTO(Long id, Double price, Period period, Integer drugAmount, Drug drug) {
		super();
		this.price = price;
		this.period = period;
		this.drugAmount = drugAmount;
		this.drug = drug;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Integer getDrugAmount() {
		return drugAmount;
	}

	public void setDrugAmount(Integer drugAmount) {
		this.drugAmount = drugAmount;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	
}
