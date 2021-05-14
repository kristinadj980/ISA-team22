package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Examination.ExaminationStatus;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Repository.ExaminationRepository;
import ISA.Team22.Repository.PatientRepository;
import ISA.Team22.Repository.PersonRepository;
import ISA.Team22.Service.IService.IExaminationService;

@Service
public class ExaminationService implements IExaminationService {

	private final ExaminationRepository examinationRepository;
	
	
	@Autowired
	public ExaminationService(ExaminationRepository examinationRepository) {
		this.examinationRepository = examinationRepository;	
	}
	
	public boolean canDermatologistMakeComplaint(Long dermatologistId) {

        Boolean isAble = false; 
        List<Examination> examinations = findAll();
        
        for (Examination examination : examinations) {
			if(examination.getDermatologist().getId().equals(dermatologistId) && examination.getExaminationStatus() == ExaminationStatus.held) {
					isAble = true;
			}
		}
       
        return isAble;
	}

	@Override
	public List<Examination> findAll() {
		return examinationRepository.findAll();
	}
	
}
