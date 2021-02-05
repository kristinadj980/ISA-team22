package domain;

import java.util.Collection;
import java.util.Date;

public class EPrescription {
	private String code;
	private Date prescriptionDate;
	public java.util.Collection<PurchaseOrderDTO> purchaseOrderDTO;
	public Patient patient;
	
	public EPrescription() {
		super();
	}
	public EPrescription(String code, Date prescriptionDate, Collection<PurchaseOrderDTO> purchaseOrderDTO,
			Patient patient) {
		super();
		this.code = code;
		this.prescriptionDate = prescriptionDate;
		this.purchaseOrderDTO = purchaseOrderDTO;
		this.patient = patient;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	public java.util.Collection<PurchaseOrderDTO> getPurchaseOrderDTO() {
		return purchaseOrderDTO;
	}
	public void setPurchaseOrderDTO(java.util.Collection<PurchaseOrderDTO> purchaseOrderDTO) {
		this.purchaseOrderDTO = purchaseOrderDTO;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
