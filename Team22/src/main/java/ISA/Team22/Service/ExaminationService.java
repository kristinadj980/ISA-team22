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
import ISA.Team22.Domain.DTO.TermAvailabilityCheckDTO;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayDermatologist;
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
	private final CounselingService counselingService;
	private final BusinessDayDermatologistService businessDayDermatologistService;
	
	@Autowired
	public ExaminationService(ExaminationRepository examinationRepository, DermatologistService dermatologistService,
			PharmacyService pharmacyService, PatientService patientService,  CounselingService counselingService,
			BusinessDayDermatologistService businessDayDermatologistService) {
		super();
		this.examinationRepository = examinationRepository;
		this.dermatologistService = dermatologistService;
		this.pharmacyService = pharmacyService;
		this.patientService = patientService;
		this.counselingService = counselingService;
		this.businessDayDermatologistService = businessDayDermatologistService;
	}

	@Override
	public String scheduleNewExamination(ExaminationDTO examinationDTO) {
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
		TermAvailabilityCheckDTO term = new TermAvailabilityCheckDTO(patient.getId(), startDate, startTime, endTime);
		Boolean checkPatient = checkPatientExaminationSchedule(term);
		Boolean checkCounseling =counselingService.checkPatientCounselingSchedule(term);
		if(checkPatient) {
			if(checkCounseling)
				if(checkDermatologistSchedule(examination)) {
					examinationRepository.save(examination);
					return("Examination is scheduled!");
				}else return("Dermatologist is not free, please choose another date or time!");
			else return("Patient has counceling in that time, please choose another date or time!");
		}else return("Patient has another examination in that time, please choose another date or time!");
	
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
		for(Examination e:allExaminations) {	
			if(e.getPatient().getId().equals(id))
				examinations.add(e);
			else if(e.getPatient().getId() == null)
				continue;
		}
			
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
	public Boolean checkPatientExaminationSchedule(TermAvailabilityCheckDTO term) {
		List<Examination> examinations = getAllPatientExaminations(term.getPatientID());
		if (examinations == null)
			return true;
		for(Examination e:examinations) {
			if(term.getStartDate().equals(e.getStartDate())) {
				if(term.getStartTime().isAfter(e.getStartTime())  && term.getStartTime().isBefore(e.getEndTime()))
					return false;
				else if(term.getEndTime().isAfter(e.getStartTime())  && term.getEndTime().isBefore(e.getEndTime())) 
					return false;
				else if(e.getStartTime().isAfter(term.getStartTime())  && e.getEndTime().isBefore(term.getEndTime()))
					return false;
				else if(term.getStartTime().equals(e.getStartTime()))
						return false;
				else return true;
			}else continue;
		}
		return true;
	}

	@Override
	public Boolean checkDermatologistSchedule(Examination examination) {
		//first we found does dermatologist work that day we need
		BusinessDayDermatologist businessDayDermatologist = businessDayDermatologistService.getDermatolgistBusinessDay(examination.getDermatologist().getId(), examination.getStartDate(), examination.getPharmacy().getId());
		if(businessDayDermatologist.getId() == null)
			return false;
		
		//second we found does dermatologist have any other scheduled examination that day we need
		List<Examination> examinations = getAllDermatologistExamination(examination.getDermatologist().getId());
		for(Examination e:examinations)
			if(examination.getStartDate().equals(e.getStartDate())) {
			System.out.println("Datum pregleda koji treba da zakazem" + examination.getStartDate()+"Datum zakazanog" + e.getStartDate());
				if(examination.getStartTime().isAfter(e.getStartTime())  && examination.getStartTime().isBefore(e.getEndTime()))
					return false;
				else if(examination.getEndTime().isAfter(e.getStartTime())  && examination.getEndTime().isBefore(e.getEndTime())) 
					return false;
				else if(e.getStartTime().isAfter(examination.getStartTime())  && e.getEndTime().isBefore(examination.getEndTime()))
					return false;
				else if(examination.getStartTime().equals(e.getStartTime()))
					return false;
				else return true;
			}else continue;
		return true;
	}
}
