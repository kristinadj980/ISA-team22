package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PharmacyAdministratorRepository;
import ISA.Team22.Service.IService.IPharmacyAdministratorService;

@Service
public class PharmacyAdministratorService implements IPharmacyAdministratorService {

	@Autowired
	private PharmacyAdministratorRepository pharmacyAdministratorRepository;
}
