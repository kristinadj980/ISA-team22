package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.Examination.Examination;

public interface IExaminationService {
	
	void scheduleNewExamination(ExaminationDTO examinationDTO);
	List<ExaminationDTO> getFreeScheduledExaminations(Long id);
	List<Examination> getAllPatientExaminations(Long id);
	List<Examination> getAllDermatologistExamination(Long id);
	Boolean checkPatientSchedule(Examination examination);
	Boolean checkDermatologistSchedule(Examination examination);
	
}
