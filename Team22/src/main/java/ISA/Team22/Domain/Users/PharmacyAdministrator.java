package ISA.Team22.Domain.Users;

import java.util.List;

import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.Notification;

public class PharmacyAdministrator {
	
	private Pharmacy pharmacy;
	private List<PurchaseOrder> purchaseOrders;
	private List<AbsenceRequestDermatologist> absenceRequests;
	private List<AbsenceRequestPharmacist> absenceRequestPharmacists;
	private List<Notification> notifications;
	
	public PharmacyAdministrator() {
		super();
	}

	public PharmacyAdministrator(Pharmacy pharmacy, List<PurchaseOrder> purchaseOrders,
			List<AbsenceRequestDermatologist> absenceRequest, List<Notification> notification,List<AbsenceRequestPharmacist> absenceRequestPharmacist) {
		super();
		this.pharmacy = pharmacy;
		this.purchaseOrders = purchaseOrders;
		this.absenceRequests = absenceRequest;
		this.notifications = notification;
		this.absenceRequestPharmacists = absenceRequestPharmacist;
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

	public List<AbsenceRequestDermatologist> getAbsenceRequest() {
		return absenceRequests;
	}

	public void setAbsenceRequest(List<AbsenceRequestDermatologist> absenceRequest) {
		this.absenceRequests = absenceRequest;
	}

	public List<Notification> getNotification() {
		return notifications;
	}

	public void setNotification(List<Notification> notification) {
		this.notifications = notification;
	}

	public List<AbsenceRequestPharmacist> getAbsenceRequestPharmacist() {
		return absenceRequestPharmacists;
	}

	public void setAbsenceRequestPharmacist(List<AbsenceRequestPharmacist> absenceRequestPharmacist) {
		this.absenceRequestPharmacists = absenceRequestPharmacist;
	}
	   
	 
}
