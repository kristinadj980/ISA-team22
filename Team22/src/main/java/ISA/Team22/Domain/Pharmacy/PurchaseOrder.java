package ISA.Team22.Domain.Pharmacy;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.DTO.PurchaseOrderDTO;
import ISA.Team22.Domain.Users.PharmacyAdministrator;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private PurchaseOrderStatus purchaseOrderStatus;
	
	@Column(name = "drugAmount",  nullable = false)
	private Integer drugAmount;
	
	@Column(name = "dueDate",  nullable = false)
	private Date dueDate;
	
	
	private PharmacyAdministrator pharmacyAdministrator;
	private List<Offer> offer;
	private List<PurchaseOrderDTO> purchaseOrderDTO;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Long id, PurchaseOrderStatus purchaseOrderStatus, Integer drugAmount, Date dueDate,
			PharmacyAdministrator pharmacyAdministrator, List<Offer> offer, List<PurchaseOrderDTO> purchaseOrderDTO) {
		super();
		this.id = id;
		this.purchaseOrderStatus = purchaseOrderStatus;
		this.drugAmount = drugAmount;
		this.dueDate = dueDate;
		this.pharmacyAdministrator = pharmacyAdministrator;
		this.offer = offer;
		this.purchaseOrderDTO = purchaseOrderDTO;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	public Integer getDrugAmount() {
		return drugAmount;
	}

	public void setDrugAmount(Integer drugAmount) {
		this.drugAmount = drugAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public PharmacyAdministrator getPharmacyAdministrator() {
		return pharmacyAdministrator;
	}

	public void setPharmacyAdministrator(PharmacyAdministrator pharmacyAdministrator) {
		this.pharmacyAdministrator = pharmacyAdministrator;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

	public List<PurchaseOrderDTO> getPurchaseOrderDTO() {
		return purchaseOrderDTO;
	}

	public void setPurchaseOrderDTO(List<PurchaseOrderDTO> purchaseOrderDTO) {
		this.purchaseOrderDTO = purchaseOrderDTO;
	}

	 
	   
}
