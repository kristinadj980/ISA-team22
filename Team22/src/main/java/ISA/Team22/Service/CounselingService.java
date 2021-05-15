package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.TermAvailabilityCheckDTO;
import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Repository.CounselingRepository;
import ISA.Team22.Service.IService.ICounselingService;

@Service
public class CounselingService implements ICounselingService {

	
	private final  CounselingRepository counselingRepository;
	
	@Autowired
	public CounselingService(CounselingRepository counselingRepository) {
		super();
		this.counselingRepository = counselingRepository;
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
	
}
