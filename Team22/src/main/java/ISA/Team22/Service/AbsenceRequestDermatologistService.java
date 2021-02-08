package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.AbsenceRequestDermatologistRepository;
import ISA.Team22.Service.IService.IAbsenceRequestDermatologistService;

@Service
public class AbsenceRequestDermatologistService implements IAbsenceRequestDermatologistService {

	@Autowired
	private AbsenceRequestDermatologistRepository absenceRequestDermatologistRepository;
}
