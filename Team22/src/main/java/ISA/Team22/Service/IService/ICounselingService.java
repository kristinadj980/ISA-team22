package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.DTO.CounselingDTO;
import ISA.Team22.Domain.DTO.TermAvailabilityCheckDTO;
import ISA.Team22.Domain.Examination.Counseling;


public interface ICounselingService {
	
	List<Counseling> getAllCounselings();
	Boolean checkPatientCounselingSchedule(TermAvailabilityCheckDTO term);
	String scheduleCounselling(CounselingDTO counselingDTO);
	Boolean checkPharmacistSchedule(Counseling counseling);
	List<Counseling> getAllPharmacistCounselings(Long id);
	Boolean checkPatientExaminationSchedule(TermAvailabilityCheckDTO term);
	List<Counseling> findAll();
}
