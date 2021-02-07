package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PromotionRepository;
import ISA.Team22.Service.IService.IPromotionService;

@Service
public class PromotionService implements IPromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
}
