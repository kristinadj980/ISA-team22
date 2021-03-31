package ISA.Team22.Service.IService;


import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;


public interface IDrugService {
	
	Drug save(DrugDTO drugDTO);
	Drug findByName(String name);
	Drug findByCode(String code);
    
}
