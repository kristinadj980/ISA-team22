package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PatientRepository;
import ISA.Team22.Service.IService.IPatientService;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private  PatientRepository patientRepository;
}
