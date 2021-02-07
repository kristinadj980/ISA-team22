package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PrescriptionRepository;
import ISA.Team22.Service.IService.IPrescriptionService;

@Service
public class PrescriptionService implements IPrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
}
