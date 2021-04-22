package ISA.Team22.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Pharmacy> getAllPharmacyDermatolgist(Long id) {
		System.out.print(id);
		System.out.println("SERVI***************************************************************S");
		List<Pharmacy> pharm = pharmacyRepository.getAllPharmacyDermatolgist(id);
		System.out.println("SERVI***************************************************************S");
		for(int i=0; i<= pharm.size(); i++) {
			System.out.print(pharm.get(i));
		}
		return pharm;
		//return pharmacyRepository.getAllPharmacyDermatolgist(id);
	}

}
