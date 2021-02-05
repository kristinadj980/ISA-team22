package domain;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {
	
	private PurchaseOrderStatus purchaseOrderStatus;
	private int drugAmount;
	private Date dueDate;
	private PharmacyAdministrator pharmacyAdministrator;
	private List<Offer> offer;
	private List<PurchaseOrderDTO> purchaseOrderDTO;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(PurchaseOrderStatus purchaseOrderStatus, int drugAmount, Date dueDate,
			PharmacyAdministrator pharmacyAdministrator, List<Offer> offer, List<PurchaseOrderDTO> purchaseOrderDTO) {
		super();
		this.purchaseOrderStatus = purchaseOrderStatus;
		this.drugAmount = drugAmount;
		this.dueDate = dueDate;
		this.pharmacyAdministrator = pharmacyAdministrator;
		this.offer = offer;
		this.purchaseOrderDTO = purchaseOrderDTO;
	}

	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	public int getDrugAmount() {
		return drugAmount;
	}

	public void setDrugAmount(int drugAmount) {
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
