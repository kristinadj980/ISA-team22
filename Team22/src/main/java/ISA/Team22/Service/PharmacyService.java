package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Repository.PharmacyRepository;
import ISA.Team22.Service.IService.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

	private final PharmacyRepository pharmacyRepository;
	
	@Autowired
	public PharmacyService(PharmacyRepository pharmacyRepository) {
		super();
		this.pharmacyRepository = pharmacyRepository;
	}

	@Override
	public List<PharmacyBasicDTO> getAllPharmacyDermatolgist(Long id) {
		List<Pharmacy> pharmacies = pharmacyRepository.getAllPharmacyDermatolgist(id);
		List<PharmacyBasicDTO> pharmaciesDTO = new ArrayList<PharmacyBasicDTO>();
		for(Pharmacy p: pharmacies)
			pharmaciesDTO.add(new PharmacyBasicDTO(p.getId(), p.getName()));
		
		return pharmaciesDTO;
	}

}
