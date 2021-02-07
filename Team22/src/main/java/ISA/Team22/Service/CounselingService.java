package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.CounselingRepository;
import ISA.Team22.Service.IService.ICounselingService;

@Service
public class CounselingService implements ICounselingService {

	@Autowired
	private  CounselingRepository counselingRepository;
}
