package ISA.Team22.Service.IService;


import java.util.List;

import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DTO.DrugSearchDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;


public interface IDrugService {
	
	Drug save(DrugDTO drugDTO);
	Drug findByName(String name);
	Drug findByCode(String code);
    List<Drug> findAllDrugs();
    Drug findById(Long id);
    List<DrugSearchDTO> sortDrugs(DrugSearchDTO sortingKey);
}
