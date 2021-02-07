package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.DrugRepository;
import ISA.Team22.Repository.DrugReservationRepository;
import ISA.Team22.Service.IService.IDrugService;

@Service
public class DrugService implements IDrugService {

	@Autowired
	private  DrugRepository drugRepository;
}
