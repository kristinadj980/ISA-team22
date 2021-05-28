package ISA.Team22.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PharmacyDrugAvailabilityDTO;
import ISA.Team22.Domain.DTO.QRCodeDTO;
import ISA.Team22.Domain.DrugManipulation.DrugInfo;
import ISA.Team22.Domain.Examination.EPrescription;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Repository.EPrescriptionRepository;
import ISA.Team22.Service.IService.IEPrescriptionService;
import javassist.NotFoundException;

@Service
public class EPrescriptionService implements IEPrescriptionService  {
	
	
	private  final EPrescriptionRepository ePrescriptionRepository;
	private final PharmacyService pharmacyService;
	
	@Autowired
	public EPrescriptionService(EPrescriptionRepository ePrescriptionRepository,PharmacyService pharmacyService) {
		this.ePrescriptionRepository = ePrescriptionRepository;
		this.pharmacyService = pharmacyService;
	}

	@Override
	public EPrescription findByCode(String code) {
		return ePrescriptionRepository.findByCode(code);
	}
	
	@Override
	public String getEReceiptCode(String decodedText) {
        String []code = decodedText.split("!");
        return code[0];
    }
	
	public static String decodeQRCode(File qrCodeimage) throws IOException, NotFoundException {
	        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
	        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
	        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

	        try {
	            Result result = new MultiFormatReader().decode(bitmap);
	            return result.getText();
	        } catch ( com.google.zxing.NotFoundException n) {
	            System.out.println("There is no QR code in the image");
	            return null;
	        }
	    }
	 
	@Override
	 public List<QRCodeDTO> getDrugsInQRcode(String decodedText) {
	        List<QRCodeDTO> qrCodeDTOs = new ArrayList<>();
	        if(decodedText.contains(";")) {
	            String []code = decodedText.split("!");
	            String []drugs = code[1].split(";");
	            for (String drug: drugs) {
	                String []drugParts = drug.split("_");
	               
	                qrCodeDTOs.add(new QRCodeDTO(drugParts[0],Long.parseLong(drugParts[1]),Integer.parseInt(drugParts[2])));
	            }
	            for (QRCodeDTO qr : qrCodeDTOs) {
					System.out.println(qr.getDrugName());
					System.out.println(qr.getDrugCode());
					System.out.println(qr.getAmount());
				}
	        }
	        else {
	            String []code = decodedText.split("!");
	            String []drugParts = code[1].split("_");
	            qrCodeDTOs.add(new QRCodeDTO(drugParts[0],Long.parseLong(drugParts[1]),Integer.parseInt(drugParts[2])));
	        }
	        return qrCodeDTOs;
	    }
	
	
	 @Override
	 public List<PharmacyDrugAvailabilityDTO> getAvailabilityInPharmacies(List<QRCodeDTO> qrCodeDrugs) {
	        List<PharmacyDrugAvailabilityDTO> pharmacyList = new ArrayList<>();
	        List<Pharmacy> pharmacies = pharmacyService.findAll();
	        Double sumPrice = 0.0;
	        for(Pharmacy pharmacy : pharmacies) {
	        	List<DrugInfo> drugInfos = pharmacy.getPharmacyInventory().getDrugInfos();
	        	for (DrugInfo drugInfo : drugInfos) {
					for (QRCodeDTO qrCodeDrug : qrCodeDrugs) {
						if(drugInfo.getDrug().getName().equals(qrCodeDrug.getDrugName()) && drugInfo.getDrugAmount() >= qrCodeDrug.getAmount()) {
							Double price = drugInfo.getPrice();
							sumPrice += price;
							AddressDTO address = new AddressDTO(pharmacy.getAddress().getCity().getName(), pharmacy.getAddress().getStreetName(),
				        			pharmacy.getAddress().getStreetNumber(), pharmacy.getAddress().getCity().getCountry().getName());
							
				            pharmacyList.add(new PharmacyDrugAvailabilityDTO(pharmacy.getId(), sumPrice, pharmacy.getAllGrades(), address, pharmacy.getName()));
						}
					}
				}
	        }
	        return pharmacyList;
	    }

}
