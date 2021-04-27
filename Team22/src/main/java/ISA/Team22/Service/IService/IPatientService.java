package ISA.Team22.Service.IService;

import ISA.Team22.Domain.DTO.PersonRequestDTO;
import ISA.Team22.Domain.Users.Patient;

public interface IPatientService {
	Patient findByEmail(String email);
	Patient save(PersonRequestDTO userRequest);
	Patient findById(Long id);
}
