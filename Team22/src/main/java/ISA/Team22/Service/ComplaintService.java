package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.ComplaintDTO;
import ISA.Team22.Domain.PharmacyWorkflow.Complaint;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Repository.ComplaintRepository;
import ISA.Team22.Repository.PatientRepository;
import ISA.Team22.Service.IService.IComplaintService;

@Service
public class ComplaintService implements IComplaintService {

	private final ComplaintRepository complaintRepository;
	private final PatientRepository patientRepository;
	
	@Autowired
	public ComplaintService(ComplaintRepository complaintRepository,PatientRepository patientRepository) {
		this.complaintRepository = complaintRepository;
		this.patientRepository = patientRepository;
	}
	


	@Override
	public Complaint save(ComplaintDTO complaintDTO) {
		
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person)currentUser.getPrincipal();
        Patient patient = patientRepository.findById(person.getId()).get();
        
		Complaint complaint = new Complaint();
		complaint.setDescription(complaintDTO.getDescription());
        complaint.setRoleId(complaintDTO.getRoleId());
        complaint.setAnswer(complaintDTO.getAnswer());
        complaint.setAnswered(complaintDTO.getIsAnswered());
        complaint.setPatient(patient);
        
        return complaintRepository.save(complaint);
	}
}
