package ISA.Team22.Domain.Examination;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import ISA.Team22.Domain.DTO.PurchaseOrderDTO;
import ISA.Team22.Domain.Users.Patient;

public class EPrescription {
	private String code;
	private Date prescriptionDate;
	public List<PurchaseOrderDTO> purchaseOrderDTO;
	public Patient patient;
	
	public EPrescription() {
		super();
	}
	public EPrescription(String code, Date prescriptionDate, List<PurchaseOrderDTO> purchaseOrderDTO,
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
	public List<PurchaseOrderDTO> getPurchaseOrderDTO() {
		return purchaseOrderDTO;
	}
	public void setPurchaseOrderDTO(List<PurchaseOrderDTO> purchaseOrderDTO) {
		this.purchaseOrderDTO = purchaseOrderDTO;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
