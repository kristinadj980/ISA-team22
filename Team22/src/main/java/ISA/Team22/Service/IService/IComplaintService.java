package ISA.Team22.Service.IService;

import ISA.Team22.Domain.DTO.ComplaintDTO;
import ISA.Team22.Domain.PharmacyWorkflow.Complaint;

public interface IComplaintService {
	Complaint save(ComplaintDTO complaintDTO);

}
