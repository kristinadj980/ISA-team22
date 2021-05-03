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

		Examination examination = new Examination( startDate, startTime, endTime, duration, 2500.50, ExaminationStatus.scheduled,"no diagnos", dermatologist, patient, pharmacy, null);
		if(checkPatientSchedule(examination) == true)
			if(checkDermatologistSchedule(examination))
				examinationRepository.save(examination);
		
		
	}

	@Override
	public List<ExaminationDTO> getFreeScheduledExaminations(Long id) {
		List<Examination> examinations = examinationRepository.findAll();
		List<ExaminationDTO> examinationsDTO = new ArrayList<ExaminationDTO>();
		
		for(Examination e:examinations) {
			if(e.getPatient() == null && e.getDermatologist().getId() == id) {
				examinationsDTO.add(new ExaminationDTO(e.getPharmacy().getId(), e.getStartDate(), e.getStartTime(), e.getEndTime(), e.getDuration(), e.getId(), e.getPharmacy().getName()));
			}
		}
		return examinationsDTO;
	}

	@Override
	public List<Examination> getAllPatientExaminations(Long id) {
		List<Examination> allExaminations = examinationRepository.findAll();
		List<Examination> examinations = new ArrayList<Examination>();
		for(Examination e:allExaminations)
			if(e.getPatient().getId() == id)
				examinations.add(e);
			
		return examinations;
	}

	@Override
	public List<Examination> getAllDermatologistExamination(Long id) {
		List<Examination> allExaminations = examinationRepository.findAll();
		List<Examination> examinations = new ArrayList<Examination>();
		for(Examination e:allExaminations)
			if(e.getDermatologist().getId() == id)
				examinations.add(e);
		
		return examinations;
	}

	@Override
	public Boolean checkPatientSchedule(Examination examination) {
		List<Examination> examinations = getAllPatientExaminations(examination.getPatient().getId());
		if (examinations == null)
			return true;
		
		for(Examination e:examinations)
			if(examination.getStartDate() == e.getStartDate())
				if(examination.getStartTime().isAfter(e.getEndTime()) || examination.getEndTime().isBefore(e.getStartTime()))
					return true;
				
		return false;
	}

	@Override
	public Boolean checkDermatologistSchedule(Examination examination) {
		List<Examination> examinations = getAllDermatologistExamination(examination.getDermatologist().getId());
		for(Examination e:examinations)
			if(examination.getStartDate() == e.getStartDate())
				if(examination.getStartTime().isAfter(e.getEndTime()) || examination.getEndTime().isBefore(e.getStartTime()))
					return true;
		
		return false;
	}
}
