package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.EPrescriptionRepository;
import ISA.Team22.Service.IService.IEPrescriptionService;

@Service
public class EPrescriptionService implements IEPrescriptionService  {
	
	@Autowired
	private  EPrescriptionRepository ePrescriptionRepository;

}
