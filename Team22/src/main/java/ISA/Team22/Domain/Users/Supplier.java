package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Domain.Pharmacy.Offer;

@Entity
public class Supplier extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Offer> offers;
	
	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SupplierDrugStock> drugStocks;

	public Supplier() {
		super();
	}

	public Supplier(Long id, List<Offer> offers, List<SupplierDrugStock> drugStocks) {
		super();
		this.id = id;
		this.offers = offers;
		this.drugStocks = drugStocks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public List<SupplierDrugStock> getDrugStocks() {
		return drugStocks;
	}

	public void setDrugStocks(List<SupplierDrugStock> drugStocks) {
		this.drugStocks = drugStocks;
	}

	
	
}
