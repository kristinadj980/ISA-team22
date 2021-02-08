package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PharmacistRepository;
import ISA.Team22.Service.IService.IPharmacistService;

@Service
public class PharmacistService implements IPharmacistService {

	@Autowired
	private PharmacistRepository pharmacistRepository;
}
