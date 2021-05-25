package ISA.Team22.Controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import ISA.Team22.Domain.DTO.DrugAvailabilityDTO;
import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.DTO.UserInfoComplaintDTO;
import ISA.Team22.Domain.DrugManipulation.DrugInfo;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Pharmacy.PharmacyInventory;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.Pharmacist;

import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Service.DermatologistService;
import ISA.Team22.Service.PharmacyService;

@RestController
@RequestMapping(value = "/api/pharmacy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {

	private final PharmacyService pharmacyService;
	private final DermatologistService dermatologistService;

	@Autowired
	public PharmacyController(PharmacyService pharmacyService, DermatologistService dermatologistService) {
		this.pharmacyService = pharmacyService;
		this.dermatologistService = dermatologistService;
	}

	@GetMapping("/pharmacystaff/dermatologist")
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	public ResponseEntity<List<PharmacyBasicDTO>> getAllPharmacyDermatolgist() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		Dermatologist dermatologist = dermatologistService.getById(person.getId());
		List<PharmacyBasicDTO> pharmacies = pharmacyService.getAllPharmacyDermatolgist(dermatologist.getId());
		
		for(PharmacyBasicDTO p:pharmacies) {
			System.out.println(p.getName());
		}
		
		return new ResponseEntity<>(pharmacies, HttpStatus.OK);
	}

	@PostMapping("/registerPharmacy")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public ResponseEntity<String> addUser(@RequestBody PharmacyDTO pharmacyDTO) {

        Pharmacy pharmacy = pharmacyService.save(pharmacyDTO);
        return new ResponseEntity<>("Pharmacy is successfully registred!", HttpStatus.CREATED);
    }
	
	@GetMapping("/pharmacies")
	@PreAuthorize("hasRole('PATIENT')")  //mozda treba za jos koju rolu
	public ResponseEntity<List<PharmacyBasicDTO>> getAllPharmacies() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		List<Pharmacy> pharmacies = pharmacyService.findAll();
		List<PharmacyBasicDTO> pharmaciesDTOs = new ArrayList<PharmacyBasicDTO>();
		
		for(Pharmacy p:pharmacies) {
			PharmacyBasicDTO pharmacyBasicDTO = new PharmacyBasicDTO(p.getId(), p.getName());
			pharmaciesDTOs.add(pharmacyBasicDTO);
		}
		
		return ResponseEntity.ok(pharmaciesDTOs);
	}
	
	
	@PostMapping("/checkDrugAvailability")
	@PreAuthorize("hasAnyRole('PATIENT', 'SYSTEM_ADMINISTRATOR', 'DERMATOLOGIST', 'PHARMACY_ADMINISTRATOR', 'PHARMACIST','UNAUTHORISED')")
    public ResponseEntity<List<DrugAvailabilityDTO>> getAvailability ( @RequestBody DrugAvailabilityDTO drugAvailabilityDTO){
		 
        List<DrugAvailabilityDTO> drugAvailabilityDTOs = pharmacyService.getAvailabilityInPharmacies(drugAvailabilityDTO.getDrugCode());

        return drugAvailabilityDTOs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugAvailabilityDTOs);
    }
    
    @PostMapping("/isDrugAvailable")
    @PreAuthorize("hasRole('DERMATOLOGIST')")
    public ResponseEntity<Boolean> checkDrugAvailabilityForExamination ( @RequestBody DrugAvailabilityDTO drugAvailabilityDTO){
		 
    	Boolean isAvailable = pharmacyService.checkDrugAvailabilityForExamination(drugAvailabilityDTO);

        return isAvailable == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(isAvailable);
    }
}
