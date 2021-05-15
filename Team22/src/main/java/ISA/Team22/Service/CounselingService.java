package ISA.Team22.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.Examination.Counseling;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Repository.CounselingRepository;
import ISA.Team22.Service.IService.ICounselingService;

@Service
public class CounselingService implements ICounselingService {

	private  CounselingRepository counselingRepository;
	
	@Autowired
	public CounselingService(CounselingRepository counselingRepository) {
		this.counselingRepository = counselingRepository;
	}
	
	public boolean canPharmacistMakeComplaint(Long pharmacistId) {
        Boolean isAble = false; 
        List<Counseling> counselings = findAll();
        for (Counseling counseling : counselings) {
			if(counseling.getPharmacist().getId().equals(pharmacistId) && counseling.getCounselingStatus() == ExaminationStatus.held) {
					isAble = true;
			}
		}
       
        return isAble;
	}

	@Override
	public List<Counseling> findAll() {
		return counselingRepository.findAll();
	}
	
}
