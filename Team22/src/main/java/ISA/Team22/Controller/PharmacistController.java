package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PharmacistDTO;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.Pharmacist;
import ISA.Team22.Service.PharmacistService;

@RestController
@RequestMapping(value = "/api/pharmacist", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PharmacistController {

	private final PharmacistService pharmacistService;

	@Autowired
	public PharmacistController(PharmacistService pharmacistService) {
		this.pharmacistService = pharmacistService;
	}
	
	@GetMapping("/profile")
	@PreAuthorize("hasRole('PHARMACIST')")
	public ResponseEntity<PharmacistDTO> getMyAccount() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		Pharmacist pharmacist = pharmacistService.getById(person.getId());
		AddressDTO addressDto = new AddressDTO(pharmacist.getAddress().getCity().getName(),
				pharmacist.getAddress().getStreetName(), pharmacist.getAddress().getStreetNumber(),
				pharmacist.getAddress().getCity().getCountry().getName());
		PharmacistDTO pharmacistDTO = new PharmacistDTO(pharmacist.getName(), pharmacist.getLastName(),
				pharmacist.getEmail(), addressDto);
		return pharmacist == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(pharmacistDTO);
	}

	@PostMapping("/update")
	@PreAuthorize("hasRole('PHARMACIST')")
	public ResponseEntity<String> updatePharmacistInfo(@RequestBody PharmacistDTO pharmacistDTO) {
		System.out.println("**************************************************************");
		try {
			pharmacistService.update(pharmacistDTO);
			return new ResponseEntity<>("Profile successfully updated!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updatePassword")
	@PreAuthorize("hasRole('PHARMACIST')")
	public ResponseEntity<String> updatePharmacistPassword(@RequestBody PharmacistDTO pharmacistDTO) {
		try {
			pharmacistService.updatePassword(pharmacistDTO);
			return new ResponseEntity<>("Profile successfully updated!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}
}
