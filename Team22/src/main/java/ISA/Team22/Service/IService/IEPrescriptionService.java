package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.PharmacyDrugAvailabilityDTO;
import ISA.Team22.Domain.DTO.QRCodeDTO;
import ISA.Team22.Domain.Examination.EPrescription;


public interface IEPrescriptionService {
	EPrescription findByCode(String code);
	String getEReceiptCode(String decodedText);
	List<QRCodeDTO> getDrugsInQRcode(String decodedText);
	List<PharmacyDrugAvailabilityDTO> getAvailabilityInPharmacies(List<QRCodeDTO> qrCodeDrugs);

}
