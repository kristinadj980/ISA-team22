package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Examination.Prescription;
import ISA.Team22.Domain.Examination.PrescriptionStatus;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.City;
import ISA.Team22.Domain.Users.Country;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Repository.PatientRepository;
import ISA.Team22.Repository.PharmacyRepository;
import ISA.Team22.Service.IService.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

	private final PharmacyRepository pharmacyRepository;
	private final PatientRepository patientRepository;
	
	@Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository,PatientRepository patientRepository) {
		this.pharmacyRepository = pharmacyRepository;
		this.patientRepository = patientRepository;
	}

	@Override
	public List<PharmacyBasicDTO> getAllPharmacyDermatolgist(Long id) {
		List<Pharmacy> pharmacies = pharmacyRepository.getAllPharmacyDermatolgist(id);
		List<PharmacyBasicDTO> pharmaciesDTO = new ArrayList<PharmacyBasicDTO>();
		for(Pharmacy p: pharmacies)
			pharmaciesDTO.add(new PharmacyBasicDTO(p.getId(), p.getName()));
		
		return pharmaciesDTO;
	}

	@Override
	public Pharmacy getById(Long id) {
		 return pharmacyRepository.findById(id).get();
	}
	
	@Override
    public Pharmacy save(PharmacyDTO pharmacy) {
        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.setName(pharmacy.getName());
        pharmacy1.setDescription(pharmacy.getDescription());
        AddressDTO addressDTO = pharmacy.getAddressDTO();
        City city = new City();
        city.setName(addressDTO.getTown());
        Country country = new Country();
        country.setName(addressDTO.getCountry());
        city.setCountry(country);
        Address address = new Address(addressDTO.getStreet(),addressDTO.getNumber(),city);
        pharmacy1.setAddress(address);
        

        return pharmacyRepository.save(pharmacy1);
    }

	@Override
	public List<Pharmacy> findAll() {
		return pharmacyRepository.findAll();
	}

	@Override
	public Pharmacy findById(Long pharmacyId) {
		return pharmacyRepository.findById(pharmacyId).get();
	}
	
	public boolean canMakeComplaintPharmacy(Long pharmacyId) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person)currentUser.getPrincipal();
        Patient patient = patientRepository.findById(person.getId()).get();
        
        Boolean isAble = false; 
        List<Pharmacy> pharmacies = findAll();
        
        for (Pharmacy pharmacy : pharmacies) {
        	Boolean isAbleExaminations = checkExaminations(pharmacyId, patient, isAble);
        	Boolean isAbleCounselings = checkCounselings(pharmacyId, patient, isAble);
        	Boolean isAbleDrugs = checkDrugs(pharmacyId, patient, isAble);
        	if(isAbleExaminations && isAbleCounselings && isAbleDrugs) {
        		isAble = true;
        	}
			
		}
       
        return isAble;
	}

	private Boolean checkExaminations(Long pharmacyId, Patient patient, Boolean isAble) {
		List<Examination> examinations = patient.getExaminations();
		ExaminationStatus status = ExaminationStatus.held;
		
		for (Examination examination : examinations) {
			if(examination.getPharmacy().getId().equals(pharmacyId) && examination.getExaminationStatus().equals(status)) {
				isAble = true;
				}
			}
		
		return isAble;
	}
	
	private Boolean checkCounselings(Long pharmacyId, Patient patient, Boolean isAble) {
		List<Counseling> counselings = patient.getCounseling();  
		ExaminationStatus status = ExaminationStatus.held;
		
		for (Counseling counseling : counselings) {
			if(counseling.getPharmacist().getPharmacy().getId().equals(pharmacyId) && counseling.getCounselingStatus().equals(status)) {
				isAble = true;
			}
		}
		
		return isAble;
	}
	
	private Boolean checkDrugs(Long pharmacyId, Patient patient, Boolean isAble) {
		List<Prescription> prescriptions = patient.getPrescription();
		
		for (Prescription prescription : prescriptions) {
			if(prescription.getPharmacist().getPharmacy().getId().equals(pharmacyId) && prescription.getPrescriptionStatus() == PrescriptionStatus.taken) {
					isAble = true;
			}
		}
		
		return isAble;
	}
}
