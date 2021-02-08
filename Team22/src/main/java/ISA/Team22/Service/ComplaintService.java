package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.ComplaintRepository;
import ISA.Team22.Service.IService.IComplaintService;

@Service
public class ComplaintService implements IComplaintService {

	@Autowired
	private  ComplaintRepository complaintRepository;
}
