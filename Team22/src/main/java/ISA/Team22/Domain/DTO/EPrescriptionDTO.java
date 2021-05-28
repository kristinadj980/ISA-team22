package ISA.Team22.Domain.DTO;

import java.util.List;

public class EPrescriptionDTO {
	
	 private List<QRCodeDTO> qrCodeDrugs;
	 private String code;
	
	 public EPrescriptionDTO() {
		super();
	
	 }

	public EPrescriptionDTO(List<QRCodeDTO> qrCodeDrugs, String code) {
		super();
		this.qrCodeDrugs = qrCodeDrugs;
		this.code = code;
	}

	public List<QRCodeDTO> getQrCodeDrugs() {
		return qrCodeDrugs;
	}

	public void setQrCodeDrugs(List<QRCodeDTO> qrCodeDrugs) {
		this.qrCodeDrugs = qrCodeDrugs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
