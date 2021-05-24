package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.Examination.Examination;

import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.DTO.ExaminationUpdateDTO;
import ISA.Team22.Domain.DTO.TermAvailabilityCheckDTO;


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
	boolean canDermatologistMakeComplaint(Long dermatologistId);
	ExaminationDTO getExaminationByID(Long id);
	void registerAbsence(Long id);
	void updateExamination(ExaminationUpdateDTO examinationUpdateDTO);
	List<ExaminationDTO> getMyScheduledExaminations(Long id);
}
