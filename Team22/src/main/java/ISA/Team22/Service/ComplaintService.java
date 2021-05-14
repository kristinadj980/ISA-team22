package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.ComplaintDTO;
import ISA.Team22.Domain.PharmacyWorkflow.Complaint;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Repository.ComplaintRepository;
import ISA.Team22.Service.IService.IComplaintService;

@Service
public class ComplaintService implements IComplaintService {

	@Autowired
	private  ComplaintRepository complaintRepository;


	@Override
	public Complaint save(ComplaintDTO complaintDTO) {
		Complaint complaint = new Complaint();
		complaint.setDescription(complaintDTO.getDescription());
        complaint.setRoleId(complaintDTO.getRoleId());
        complaint.setAnswer(complaintDTO.getAnswer());
        complaint.setAnswered(complaintDTO.getIsAnswered());
        
        return complaintRepository.save(complaint);
	}
}
