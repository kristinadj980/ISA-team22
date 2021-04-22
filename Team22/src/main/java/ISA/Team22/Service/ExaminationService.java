package ISA.Team22.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Repository.ExaminationRepository;
import ISA.Team22.Service.IService.IExaminationService;

@Service
public class ExaminationService implements IExaminationService {

	private final ExaminationRepository examinationRepository;
	
	@Autowired
	public ExaminationService(ExaminationRepository examinationRepository) {
		super();
		this.examinationRepository = examinationRepository;
	}

	@Override
	public void scheduleNewExamination(ExaminationDTO examinationDTO) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();

		LocalDate startDate = LocalDate.parse(examinationDTO.getStartDate()); 
		LocalTime startTime = LocalTime.of(15, 45, 45);
		Pharmacy pharmacy = new Pharmacy();
		Examination examination = new Examination( startDate, startTime, 30, 2500.50, ExaminationStatus.scheduled,"no diagnos", null, null, pharmacy, null);

		examinationRepository.save(examination);
	}
}
