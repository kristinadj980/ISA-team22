package ISA.Team22.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DTO.DrugSearchDTO;
import ISA.Team22.Domain.DTO.DrugSpecificationDTO;
import ISA.Team22.Domain.DTO.PatientSearchDTO;
import ISA.Team22.Domain.DTO.PharmacySubsribedDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.DrugManipulation.DrugSpecification;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
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
	
	@GetMapping("getdrugs")
	@PreAuthorize("hasAnyRole('PATIENT', 'SUPPLIER', 'SYSTEM_ADMINISTRATOR', 'DERMATOLOGIST', 'PHARMACY_ADMINISTRATOR', 'PHARMACIST','UNAUTHORISED')")
	//@PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    ResponseEntity<List<DrugSearchDTO>> getAllDrugs()
    {
        List<Drug> drugs = drugService.findAllDrugs();
        List<DrugSearchDTO> drugsForFront = new ArrayList<>();
        for (Drug drug: drugs) {
        	DrugSearchDTO drugSearchDTO = drugService.findDrugSpecification(drug);
        	drugsForFront.add(drugSearchDTO);
        }
        return drugsForFront == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugsForFront);
    }
	
	 
	 @PostMapping("/searchDrug")
	 @PreAuthorize("hasAnyRole('PATIENT', 'SYSTEM_ADMINISTRATOR', 'DERMATOLOGIST', 'PHARMACY_ADMINISTRATOR', 'PHARMACIST','UNAUTHORISED')")
		public ResponseEntity<List<DrugSearchDTO>> searchDrug(@RequestBody DrugSearchDTO drugSearchDTO) {
		 List<Drug> drugs = drugService.findAllDrugs();
		 List<DrugSearchDTO> drugSearchDTOs = new ArrayList<DrugSearchDTO>();
		 for (Drug d : drugs) {
			if(d.getName().equals(drugSearchDTO.getName())){
				DrugSearchDTO drugSearchDTO1 = drugService.findDrugSpecification(d);
				drugSearchDTOs.add(drugSearchDTO1);
			}
		}
	        
	        return drugSearchDTOs == null ?
	                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
	                ResponseEntity.ok(drugSearchDTOs);
		  
		}
	 
	 @PostMapping("/getDrugSpecification")
	 @PreAuthorize("hasAnyRole('PATIENT', 'SYSTEM_ADMINISTRATOR', 'DERMATOLOGIST', 'PHARMACY_ADMINISTRATOR', 'PHARMACIST','UNAUTHORISED')")
		public ResponseEntity<DrugSearchDTO> findDrugSpecification(@RequestBody DrugSearchDTO drugSearchDTO) {
		    Drug drug = drugService.findById(drugSearchDTO.getId());
		  
		    DrugSearchDTO drugSearchDTO1 = drugService.findDrugSpecification(drug);
	        
	        return drugSearchDTO1 == null ?
	                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
	                ResponseEntity.ok(drugSearchDTO1);
		  
		}


}
