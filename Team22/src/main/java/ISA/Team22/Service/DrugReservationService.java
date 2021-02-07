package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.DrugReservationRepository;
import ISA.Team22.Service.IService.IDrugReservationService;

@Service
public class DrugReservationService implements IDrugReservationService {

	@Autowired
	private  DrugReservationRepository drugReservationRepository;
}
