package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.ExaminationDTO;

public interface IExaminationService {
	
	void scheduleNewExamination(ExaminationDTO examinationDTO);
	List<ExaminationDTO> getFreeScheduledExaminations();
}
