package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.BusinessDayDermatologistRepository;
import ISA.Team22.Service.IService.IBusinessDayDermatologistService;

@Service
public class BusinessDayDermatologistService implements IBusinessDayDermatologistService {

	@Autowired
	private  BusinessDayDermatologistRepository businessDayDermatologistRepository;
}
