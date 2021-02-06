package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Domain.Pharmacy.Offer;

@Entity
public class Supplier extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<Offer> offers;
	private List<SupplierDrugStock> drugStocks;

	public Supplier() {
		super();
	}

	public Supplier(Long id, List<Offer> offer, List<SupplierDrugStock> drugStocks) {
		super();
		this.id = id;
		this.offers = offer;
		this.drugStocks = drugStocks;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Offer> getOffer() {
		return offers;
	}

	public void setOffer(List<Offer> offer) {
		this.offers = offer;
	}

	public List<SupplierDrugStock> getDrugStocks() {
		return drugStocks;
	}

	public void setDrugStocks(List<SupplierDrugStock> drugStocks) {
		this.drugStocks = drugStocks;
	}
	
	
	
}
