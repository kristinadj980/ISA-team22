package ISA.Team22.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.PharmacyWorkflow.BusinessDayDermatologist;
import ISA.Team22.Repository.BusinessDayDermatologistRepository;
import ISA.Team22.Service.IService.IBusinessDayDermatologistService;

@Service
public class BusinessDayDermatologistService implements IBusinessDayDermatologistService {


	private final  BusinessDayDermatologistRepository businessDayDermatologistRepository;
	
	@Autowired
	public BusinessDayDermatologistService(BusinessDayDermatologistRepository businessDayDermatologistRepository) {
		super();
		this.businessDayDermatologistRepository = businessDayDermatologistRepository;
	}

	@Override
	public List<BusinessDayDermatologist> getDermatolgistBusinessDay(Long dermatologist_id, LocalDate date) {
		// TODO Auto-generated method stub
		return businessDayDermatologistRepository.getAllPharmacyDermatolgist(dermatologist_id, date);
	}
}
