package domain;

import java.util.List;

public class PharmacyAdministrator {
	
	private Pharmacy pharmacy;
	private List<PurchaseOrder> purchaseOrders;
	private List<AbsenceRequest> absenceRequest;
	private List<Notification> notification;
	
	public PharmacyAdministrator() {
		super();
	}

	public PharmacyAdministrator(Pharmacy pharmacy, List<PurchaseOrder> purchaseOrders,
			List<AbsenceRequest> absenceRequest, List<Notification> notification) {
		super();
		this.pharmacy = pharmacy;
		this.purchaseOrders = purchaseOrders;
		this.absenceRequest = absenceRequest;
		this.notification = notification;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public List<AbsenceRequest> getAbsenceRequest() {
		return absenceRequest;
	}

	public void setAbsenceRequest(List<AbsenceRequest> absenceRequest) {
		this.absenceRequest = absenceRequest;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}
	   
	 
	 
	

}
