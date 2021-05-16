package ISA.Team22.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
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
	
}
