package domain;

import java.util.List;

public class Supplier {
	
	private List<Offer> offer;

	public Supplier() {
		super();
	}

	public Supplier(List<Offer> offer) {
		super();
		this.offer = offer;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}
	
	

}
