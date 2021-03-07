package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.Users.Dermatologist;

public interface IDermatologistService {
	
	List<Dermatologist> getAllDermatologists();
	Dermatologist findByEmail(String email);
	Dermatologist save(DermatologistDTO userRequest);
}
