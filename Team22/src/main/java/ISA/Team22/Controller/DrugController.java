package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Exception.ResourceConflictException;
import ISA.Team22.Service.DrugService;

@RestController
@RequestMapping("/api/drug")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DrugController {

	private final  DrugService drugService;
	
	@Autowired
	public DrugController(DrugService drugService) {
		this.drugService = drugService;
	}
	
	@PostMapping("/addDrug")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    ResponseEntity<Drug> addDrug(@RequestBody DrugDTO drugDTO)
    {
		Drug existingDrug = drugService.findByName(drugDTO.getName());
        if(existingDrug != null)
        {
            throw new ResourceConflictException("Drug name already exists", "Drug name already exists");
        }
        Drug existingDrug2 = drugService.findByCode(drugDTO.getCode());
        if(existingDrug2 != null)
        {
            throw new ResourceConflictException("Drug code already exists", "Drug code already exists");
        }
        Drug drug = drugService.save(drugDTO);
        return (ResponseEntity<Drug>) (drug == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drug));
    }

}
