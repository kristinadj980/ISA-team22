package ISA.Team22.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Repository.DermatologistRepository;
import ISA.Team22.Service.IService.IDermatologistService;

@Service
public class DermatologistService implements IDermatologistService {

	private final DermatologistRepository dermatologistRepository;
	
	@Autowired
	public DermatologistService(DermatologistRepository dermatologistRepository) {
		this.dermatologistRepository = dermatologistRepository;
	}

	@Override
    public List<Dermatologist> getAllDermatologists() {
        return dermatologistRepository.findAll();
    }
}
