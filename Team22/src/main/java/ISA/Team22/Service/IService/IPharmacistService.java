package ISA.Team22.Service.IService;

import ISA.Team22.Domain.DTO.PharmacistDTO;
import ISA.Team22.Domain.Users.Pharmacist;

public interface IPharmacistService {
	
	Pharmacist getById(Long id);
	Pharmacist findByEmail(String email);
	Pharmacist save(PharmacistDTO userRequest);
	void update(PharmacistDTO pharmacistDTO);
	void updatePassword(PharmacistDTO pharmacistDTO);
}
