package ISA.Team22.Domain.Pharmacy;

import ISA.Team22.Domain.Users.Supplier;

public class Offer {

	private Double totalPrice;
	private int deliveryTime;
    private OfferStatus offerStatus;
    private long purchaseOrderId;
    private Supplier supplier;
    
   
	public Offer() {
		super();
	}


	public Offer(Double totalPrice, int deliveryTime, OfferStatus offerStatus, long purchaseOrder,
			Supplier supplier) {
		super();
		this.totalPrice = totalPrice;
		this.deliveryTime = deliveryTime;
		this.offerStatus = offerStatus;
		this.purchaseOrderId = purchaseOrder;
		this.supplier = supplier;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public OfferStatus getOfferStatus() {
		return offerStatus;
	}


	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}


	public long getPurchaseOrder() {
		return purchaseOrderId;
	}


	public void setPurchaseOrder(long purchaseOrder) {
		this.purchaseOrderId = purchaseOrder;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	  
	
	
}
