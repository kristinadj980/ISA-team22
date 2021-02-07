package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PharmacyRepository;
import ISA.Team22.Service.IService.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

	@Autowired
	private PharmacyRepository pharmacyRepository;
}
