package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.LoyaltyProgramRepository;
import ISA.Team22.Service.IService.ILoyaltyProgramService;

@Service
public class LoyaltyProgramService implements ILoyaltyProgramService {

	@Autowired
	private  LoyaltyProgramRepository loyaltyProgramRepository;

}
