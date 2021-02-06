package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.Notification;

@Entity
public class PharmacyAdministrator extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pharmacy pharmacy;
	
	@OneToMany(mappedBy = "pharmacyAdministrator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PurchaseOrder> purchaseOrders;
	
	@ManyToMany(targetEntity = AbsenceRequestDermatologist.class,  cascade = CascadeType.ALL)
	private List<AbsenceRequestDermatologist> absenceRequests;
	
	@ManyToMany(targetEntity = AbsenceRequestPharmacist.class,  cascade = CascadeType.ALL)
	private List<AbsenceRequestPharmacist> absenceRequestPharmacists;
	
	@ManyToMany(targetEntity = Notification.class,  cascade = CascadeType.ALL)
	private List<Notification> notifications;
	
	public PharmacyAdministrator() {
		super();
	}

	public PharmacyAdministrator(Long id, Pharmacy pharmacy, List<PurchaseOrder> purchaseOrders,
			List<AbsenceRequestDermatologist> absenceRequest, List<Notification> notification,List<AbsenceRequestPharmacist> absenceRequestPharmacist) {
		super();
		this.id = id;
		this.pharmacy = pharmacy;
		this.purchaseOrders = purchaseOrders;
		this.absenceRequests = absenceRequest;
		this.notifications = notification;
		this.absenceRequestPharmacists = absenceRequestPharmacist;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
