package domain;

public class Offer {

	private Double totalPrice;
	private int deliveryTime;
    private OfferStatus offerStatus;
    private PurchaseOrder purchaseOrder;
    private Supplier supplier;
    
   
	public Offer() {
		super();
	}


	public Offer(Double totalPrice, int deliveryTime, OfferStatus offerStatus, PurchaseOrder purchaseOrder,
			Supplier supplier) {
		super();
		this.totalPrice = totalPrice;
		this.deliveryTime = deliveryTime;
		this.offerStatus = offerStatus;
		this.purchaseOrder = purchaseOrder;
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


	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}


	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	  
	
	
}
