package ISA.Team22.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.DrugManipulation.DrugSpecification;
import ISA.Team22.Repository.DrugRepository;
import ISA.Team22.Service.IService.IDrugService;

@Service
public class DrugService implements IDrugService {
	
	private final DrugRepository drugRepository;

	@Autowired
	public DrugService(DrugRepository drugRepository){
		this.drugRepository = drugRepository;
	}

	@Override
	public Drug save(DrugDTO drugDTO) {
		Drug drug = new Drug();
		drug.setName(drugDTO.getName());
		drug.setCode(drugDTO.getCode());
		drug.setDrugType(drugDTO.getType());
		drug.setDrugForm(drugDTO.getDrugForm());
		drug.setProducer(drugDTO.getSpecification().getManufacturer());
        DrugSpecification specification =  new DrugSpecification();
        specification.setContraindications(drugDTO.getSpecification().getContraIndications());
        specification.setCompositions(drugDTO.getSpecification().getComposition());
        specification.setTherapyDuration(drugDTO.getSpecification().getTherapyDuration());
        drug.setDrugSpecification(specification);
        drug.getDrugSpecification().setAlternativeDrugCodes(drugDTO.getAlternativeDrugCodes());
        
        return drugRepository.save(drug);
	}

	@Override
	public Drug findByName(String name) {
		return drugRepository.findByName(name);
	}

	@Override
	public Drug findByCode(String code) {
		return drugRepository.findByCode(code);
	}
	
	
	
}
