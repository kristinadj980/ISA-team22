package ISA.Team22.Service;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.CounselingDTO;
import ISA.Team22.Domain.DTO.TermAvailabilityCheckDTO;
import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayPharmacist;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.Pharmacist;
import ISA.Team22.Repository.CounselingRepository;
import ISA.Team22.Service.IService.ICounselingService;

@Service
public class CounselingService implements ICounselingService {

	
	private final CounselingRepository counselingRepository;
	private final PharmacistService pharmacistService; 
	private final PatientService patientService;
	private final BusinessDayPharmacistService businessDayPharmacistService;
	private final EmailService emailServices;
	
	@Autowired
	public CounselingService(CounselingRepository counselingRepository, PharmacistService pharmacistService,
			PatientService patientService, BusinessDayPharmacistService businessDayPharmacistService, EmailService emailServices) {
		super();
		this.counselingRepository = counselingRepository;
		this.pharmacistService = pharmacistService;
		this.patientService = patientService;
		this.businessDayPharmacistService = businessDayPharmacistService;
		this.emailServices = emailServices;
	}

	@Override
	public List<Counseling> getAllCounselings() {
		return counselingRepository.findAll();
	}
	@Override
	public List<Counseling> getAllPatientCounseling(Long id) {
		List<Counseling> allCounselings = getAllCounselings();
		List<Counseling> counselings = new ArrayList<Counseling>();
		for(Counseling c:allCounselings)
			if(c.getPatient().getId() == id)
				counselings.add(c);
			
		return counselings;
	}


	@Override
	public Boolean checkPatientCounselingSchedule(TermAvailabilityCheckDTO term) {
		List<Counseling> counselings = getAllPatientCounseling(term.getPatientID());
		if (counselings.isEmpty())
			return true;
		
		for(Counseling c:counselings)
			if(term.getStartDate().equals(c.getStartDate())) {
				if(term.getStartTime().isAfter(c.getStartTime())  && term.getStartTime().isBefore(c.getEndTime()))
					return false;
				else if(term.getEndTime().isAfter(c.getStartTime())  && term.getEndTime().isBefore(c.getEndTime())) 
					return false;
				else if(c.getStartTime().isAfter(term.getStartTime())  && c.getEndTime().isBefore(term.getEndTime()))
					return false;
				else if(term.getStartTime().equals(c.getStartTime()))
					return false;
				else return true;
			}else continue;
		return true;
	}

	@Override
	public String scheduleCounselling(CounselingDTO counselingDTO) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		Pharmacist pharmacist = pharmacistService.getById(person.getId());
		LocalDate startDate = counselingDTO.getStartDate(); 
		LocalTime startTime = counselingDTO.getStartTime();
		LocalTime endTime = counselingDTO.getEndTime();
		String[] tokens = counselingDTO.getPatientInfo().split("\\s");
		Patient patient = patientService.findByEmail(tokens[3]);
		
		Counseling counseling = new Counseling(startDate, startTime, endTime, 0.0, "", pharmacist, patient, ExaminationStatus.scheduled );
		TermAvailabilityCheckDTO term = new TermAvailabilityCheckDTO(patient.getId(), startDate, startTime, endTime);
		Boolean checkCounseling = checkPatientCounselingSchedule(term);
		
		if(checkCounseling)
			if(checkPharmacistSchedule(counseling)) {
				counselingRepository.save(counseling);
				this.emailServices.sendNotificationAsync(patient.getEmail(), "Scheduled examination INFO", ""
						+ "Your examination is scheduled for date " + counseling.getStartDate().toString() + " " + counseling.getStartTime() +".");
				return ("Counseling is scheduled! ");
			}else return ("Pharmacist is  not free, choose another date or time. ");
		else return ("Patient has another counselling, choose another date or time. ");
				
	}
	
	
	@Override
	public Boolean checkPharmacistSchedule(Counseling counseling) {
		//first we found does dermatologist work that day we need
		BusinessDayPharmacist businessDayPharmacist = businessDayPharmacistService.getPharmacisttBusinessDay(counseling.getPharmacist().getId(), counseling.getStartDate());
		if(businessDayPharmacist.getId() == null)
			return false;
		
		//second we found does dermatologist have any other scheduled examination that day we need
		List<Counseling> counselings = getAllPharmacistCounselings(counseling.getPharmacist().getId());
		for(Counseling c:counselings)
			if(counseling.getStartDate().equals(c.getStartDate())) {
			System.out.println("Datum pregleda koji treba da zakazem" + counseling.getStartDate()+"Datum zakazanog" + c.getStartDate());
				if(counseling.getStartTime().isAfter(c.getStartTime())  && counseling.getStartTime().isBefore(c.getEndTime()))
					return false;
				else if(counseling.getEndTime().isAfter(c.getStartTime())  && counseling.getEndTime().isBefore(c.getEndTime())) 
					return false;
				else if(c.getStartTime().isAfter(counseling.getStartTime())  && c.getEndTime().isBefore(counseling.getEndTime()))
					return false;
				else if(counseling.getStartTime().equals(c.getStartTime()))
					return false;
				else return true;
			}else continue;
		return true;
	}
	
	@Override
	public List<Counseling> getAllPharmacistCounselings(Long id) {
		List<Counseling> allCounselings = counselingRepository.findAll();
		List<Counseling> counselings = new ArrayList<Counseling>();
		for(Counseling e:allCounselings)
			if(e.getPharmacist().getId().equals(id))
				counselings.add(e);
		
		return counselings;
	}
	
}
