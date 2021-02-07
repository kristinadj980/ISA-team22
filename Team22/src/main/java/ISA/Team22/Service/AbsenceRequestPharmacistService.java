package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.AbsenceRequestPharmacistRepository;
import ISA.Team22.Service.IService.IAbsenceRequestDermatologistService;
import ISA.Team22.Service.IService.IAbsenceRequestPharmacistService;

@Service
public class AbsenceRequestPharmacistService implements IAbsenceRequestPharmacistService{
	
	@Autowired
	private AbsenceRequestPharmacistRepository absenceRequestPharmacistRepository;
}
