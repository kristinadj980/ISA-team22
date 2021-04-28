package ISA.Team22.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Repository.ExaminationRepository;
import ISA.Team22.Service.IService.IExaminationService;

@Service
public class ExaminationService implements IExaminationService {

	private final ExaminationRepository examinationRepository;
	private final DermatologistService dermatologistService;
	private final PharmacyService pharmacyService;
	private final PatientService patientService;
	
	@Autowired
	public ExaminationService(ExaminationRepository examinationRepository, DermatologistService dermatologistService,
			PharmacyService pharmacyService, PatientService patientService) {
		super();
		this.examinationRepository = examinationRepository;
		this.dermatologistService = dermatologistService;
		this.pharmacyService = pharmacyService;
		this.patientService = patientService;
	}

	@Override
	public void scheduleNewExamination(ExaminationDTO examinationDTO) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		Dermatologist dermatologist = dermatologistService.getById(person.getId());
		LocalDate startDate = examinationDTO.getStartDate(); 
		LocalTime startTime = examinationDTO.getStartTime();
		LocalTime endTime = examinationDTO.getEndTime();
		Pharmacy pharmacy = pharmacyService.getById(examinationDTO.getPharmacyID());
		String[] tokens = examinationDTO.getPatientInfo().split("\\s");
		Patient patient = patientService.findByEmail(tokens[3]);
		Long duration = startTime.until(endTime, MINUTES);
		System.out.println(duration);
		
		Examination examination = new Examination( startDate, startTime, endTime, duration, 2500.50, ExaminationStatus.scheduled,"no diagnos", dermatologist, patient, pharmacy, null);

		examinationRepository.save(examination);
	}

	@Override
	public List<ExaminationDTO> getFreeScheduledExaminations() {
		List<Examination> examinations = examinationRepository.findAll();
		List<ExaminationDTO> examinationsDTO = new ArrayList<ExaminationDTO>();
		
		for(Examination e:examinations) {
			if(e.getPatient() == null) {
				examinationsDTO.add(new ExaminationDTO(e.getPharmacy().getId(), e.getStartDate(), e.getStartTime(), e.getEndTime(), e.getDuration(), e.getId(), e.getPharmacy().getName()));
			}
		}
		return examinationsDTO;
	}
}
