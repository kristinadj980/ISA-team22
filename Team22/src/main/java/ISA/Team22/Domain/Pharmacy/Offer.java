package ISA.Team22.Domain.Pharmacy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	@Enumerated(EnumType.ORDINAL)
    private OfferStatus offerStatus;
    
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PurchaseOrder purchaseOrder;
    
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Supplier supplier;
    
   
	public Offer() {
		super();
	}


	public Offer(Long id, Double totalPrice, Integer deliveryTime, OfferStatus offerStatus, PurchaseOrder purchaseOrder,
			Supplier supplier) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.deliveryTime = deliveryTime;
		this.offerStatus = offerStatus;
		this.purchaseOrder = purchaseOrder;
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
