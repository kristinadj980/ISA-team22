package ISA.Team22.Domain.Users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestDermatologist;
import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.Notification;

@Entity
public class PharmacyAdministrator extends Person{
	
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
			List<AbsenceRequestDermatologist> absenceRequests, List<AbsenceRequestPharmacist> absenceRequestPharmacists,
			List<Notification> notifications) {
		super();
		this.id = id;
		this.pharmacy = pharmacy;
		this.purchaseOrders = purchaseOrders;
		this.absenceRequests = absenceRequests;
		this.absenceRequestPharmacists = absenceRequestPharmacists;
		this.notifications = notifications;
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


	public List<AbsenceRequestDermatologist> getAbsenceRequests() {
		return absenceRequests;
	}


	public void setAbsenceRequests(List<AbsenceRequestDermatologist> absenceRequests) {
		this.absenceRequests = absenceRequests;
	}


	public List<AbsenceRequestPharmacist> getAbsenceRequestPharmacists() {
		return absenceRequestPharmacists;
	}


	public void setAbsenceRequestPharmacists(List<AbsenceRequestPharmacist> absenceRequestPharmacists) {
		this.absenceRequestPharmacists = absenceRequestPharmacists;
	}


	public List<Notification> getNotifications() {
		return notifications;
	}


	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}




	
}
