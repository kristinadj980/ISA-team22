package ISA.Team22.Service.IService;

import java.util.ArrayList;
import java.util.List;

import ISA.Team22.Domain.Examination.Examination;
import java.util.List;

import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.DTO.TermAvailabilityCheckDTO;
import ISA.Team22.Domain.Examination.Examination;


public interface IExaminationService {
	
	String scheduleNewExamination(ExaminationDTO examinationDTO);
	List<ExaminationDTO> getFreeScheduledExaminations(Long id);
	List<Examination> getAllPatientExaminations(Long id);
	List<Examination> getAllDermatologistExamination(Long id);
	Boolean checkPatientExaminationSchedule(TermAvailabilityCheckDTO term);
	Boolean checkDermatologistSchedule(Examination examination);
	String updateScheduledExamination(ExaminationDTO examinationDTO);
	Boolean checkPatientCounselingSchedule(TermAvailabilityCheckDTO term);
	List<Examination> findAll ();
}
