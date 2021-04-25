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
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
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
	
	/*@PostMapping("/registerPharmacy")
	@PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
	public ResponseEntity<String> registerPharmacy(@RequestBody PharmacyDTO pharmacy){
		System.out.println("Usao...");
		Pharmacy p = pharmacyService.save(pharmacy);
		return new ResponseEntity<>("Pharmacy is successfully registred!", HttpStatus.CREATED);
	}*/
	
	@PostMapping("/registerPharmacy")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public ResponseEntity<String> addUser(@RequestBody PharmacyDTO pharmacyDTO) {

        Pharmacy pharmacy = pharmacyService.save(pharmacyDTO);
        return new ResponseEntity<>("Pharmacy is successfully registred!", HttpStatus.CREATED);
    }

	
	
}
