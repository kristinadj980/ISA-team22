package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.DermatologistRepository;
import ISA.Team22.Service.IService.IDermatologistService;

@Service
public class DermatologistService implements IDermatologistService {

	@Autowired
	private  DermatologistRepository dermatologistRepository;
}
