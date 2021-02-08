package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.BusinessDayPharmacistRepository;
import ISA.Team22.Service.IService.IBusinessDayPharmacistService;


@Service
public class BusinessDayPharmacistService implements IBusinessDayPharmacistService  {

	@Autowired
	private  BusinessDayPharmacistRepository businessDayPharmacistRepository;
}
