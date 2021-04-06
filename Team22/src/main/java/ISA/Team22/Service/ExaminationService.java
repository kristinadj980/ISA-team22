package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.City;
import ISA.Team22.Domain.Users.Country;
import ISA.Team22.Domain.Users.Dermatologist;
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
		Dermatologist dermatologist = (Dermatologist) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Examination examination = new Examination(examinationDTO.getStartDate(), examinationDTO.getStartTime(), 30, ExaminationStatus.scheduled, dermatologist);
	    
	    examinationRepository.save(examination);
	}
}
