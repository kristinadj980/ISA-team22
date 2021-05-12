package ISA.Team22.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.DTO.UserInfoComplaintDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.Pharmacist;
import ISA.Team22.Service.PharmacyService;

@RestController
@RequestMapping("/api/pharmacy")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PharmacyController {

	private final  PharmacyService pharmacyService;
	
	@Autowired
	public PharmacyController(PharmacyService pharmacyService) {
		this.pharmacyService = pharmacyService;
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
	
	
}
