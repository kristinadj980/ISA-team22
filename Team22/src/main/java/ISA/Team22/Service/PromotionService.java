package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.DTO.PromotionDTO;
import ISA.Team22.Domain.DTO.PromotionPeriodDTO;
import ISA.Team22.Domain.PharmacyWorkflow.Period;
import ISA.Team22.Domain.PharmacyWorkflow.Promotion;
import ISA.Team22.Repository.PromotionRepository;
import ISA.Team22.Service.IService.IPromotionService;

@Service
public class PromotionService implements IPromotionService {

	private final PromotionRepository promotionRepository;
	
    public PromotionService(PromotionRepository promotionRepository) {
		this.promotionRepository = promotionRepository;
	}

	@Override
	public List<Promotion> findAllPromotions() {
		return promotionRepository.findAll();
	}
	
	public List<PromotionDTO> findPromotions(PharmacyBasicDTO pharmacyBasicDTO) {
		List<Promotion> promotions = findAllPromotions();
        List<PromotionDTO> promotionDtos = new ArrayList<PromotionDTO>();
        for (Promotion promotion : promotions) {
        	
            	if(promotion.getPharmacy().getId().equals(pharmacyBasicDTO.getId())) {
            		Period p = promotion.getPeriod();
            		PromotionPeriodDTO periodDTO = new PromotionPeriodDTO();
            		periodDTO.setStartDate(p.getStartDate());
            		periodDTO.setEndDate(p.getEndDate());
            		PromotionDTO dto = new PromotionDTO(promotion.getId(), promotion.getDescription(),promotion.getPharmacy().getId(),periodDTO);
            		promotionDtos.add(dto);
            	}
			
			
		}
		return promotionDtos;
	}
}
