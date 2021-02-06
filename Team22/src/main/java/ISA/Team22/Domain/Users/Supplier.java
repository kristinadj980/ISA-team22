package ISA.Team22.Domain.Users;

import java.util.List;

import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Domain.Pharmacy.Offer;

public class Supplier extends User{
	
	private List<Offer> offers;
	private List<SupplierDrugStock> drugStocks;

	public Supplier() {
		super();
	}

	public Supplier(List<Offer> offer, List<SupplierDrugStock> drugStocks) {
		super();
		this.offers = offer;
		this.drugStocks = drugStocks;
		
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
