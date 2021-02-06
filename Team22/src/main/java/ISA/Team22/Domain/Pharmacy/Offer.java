package ISA.Team22.Domain.Pharmacy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Users.Supplier;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "totalPrice",  nullable = false)
	private Double totalPrice;
	
	@Column(name = "deliveryTime",  nullable = false)
	private Integer deliveryTime;
	
    private OfferStatus offerStatus;
    
    @Column(name = "purchaseOrderId",  nullable = false)
    private Long purchaseOrderId;
    
    private Supplier supplier;
    
   
	public Offer() {
		super();
	}


	public Offer(Long id, Double totalPrice, Integer deliveryTime, OfferStatus offerStatus, Long purchaseOrder,
			Supplier supplier) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.deliveryTime = deliveryTime;
		this.offerStatus = offerStatus;
		this.purchaseOrderId = purchaseOrder;
		this.supplier = supplier;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Integer getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public OfferStatus getOfferStatus() {
		return offerStatus;
	}


	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}


	public Long getPurchaseOrder() {
		return purchaseOrderId;
	}


	public void setPurchaseOrder(Long purchaseOrder) {
		this.purchaseOrderId = purchaseOrder;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	  
	
	
}
