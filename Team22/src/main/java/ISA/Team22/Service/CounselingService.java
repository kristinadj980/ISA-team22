package ISA.Team22.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.Examination.Counseling;
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
	
	
}
