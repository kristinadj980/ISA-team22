package ISA.Team22.Domain.Examination;

import java.time.LocalDate;
import java.util.Collection;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ISA.Team22.Domain.PharmacyWorkflow.AbsenceRequestPharmacist;
import ISA.Team22.Domain.PharmacyWorkflow.PurchaseOrderDrug;
import ISA.Team22.Domain.Users.Patient;

@Entity
public class EPrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code", unique = true,  nullable = false)
	private String code;
	
	@Column(name = "prescriptionDate",  nullable = false)
	private LocalDate prescriptionDate;
	
	@ManyToMany(targetEntity = PurchaseOrderDrug.class,  cascade = CascadeType.ALL)
	public List<PurchaseOrderDrug> purchaseOrderDrugs;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Patient patient;
	
	public EPrescription() {
		super();
	}
	public EPrescription(Long id, String code, LocalDate prescriptionDate, List<PurchaseOrderDrug> purchaseOrderDrugs,
			Patient patient) {
		super();
		this.id = id;
		this.code = code;
		this.prescriptionDate = prescriptionDate;
		this.purchaseOrderDrugs = purchaseOrderDrugs;
		this.patient = patient;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public List<PurchaseOrderDrug> getPurchaseOrderDrugs() {
		return purchaseOrderDrugs;
	}
	public void setPurchaseOrderDrugs(List<PurchaseOrderDrug> purchaseOrderDrugs) {
		this.purchaseOrderDrugs = purchaseOrderDrugs;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
