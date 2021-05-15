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
		if (counselings == null)
			return true;
		
		for(Counseling c:counselings)
			if(term.getStartDate() == c.getStartDate())
				if(term.getStartTime().isAfter(c.getEndTime()) || term.getEndTime().isBefore(c.getStartTime()))
					return true;
				else return false;
			else return true;
				
		return false;
	}
	
}
