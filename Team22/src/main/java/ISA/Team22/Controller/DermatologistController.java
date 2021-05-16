package ISA.Team22.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Exception.ResourceConflictException;
import ISA.Team22.Service.DermatologistService;

@RestController
@RequestMapping(value = "/api/dermatologist", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DermatologistController {

	private final DermatologistService dermatologistService;

	@Autowired
	public DermatologistController(DermatologistService dermatologistService) {
		this.dermatologistService = dermatologistService;
	}

	@GetMapping("/profile")
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	public ResponseEntity<DermatologistDTO> getMyAccount() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		Dermatologist dermatologist = dermatologistService.getById(person.getId());
		AddressDTO addressDto = new AddressDTO(dermatologist.getAddress().getCity().getName(),
				dermatologist.getAddress().getStreetName(), dermatologist.getAddress().getStreetNumber(),
				dermatologist.getAddress().getCity().getCountry().getName());
		DermatologistDTO dermatologistDTO = new DermatologistDTO(dermatologist.getName(), dermatologist.getLastName(),
				dermatologist.getEmail(), addressDto);
		return (ResponseEntity<DermatologistDTO>) (dermatologist == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(dermatologistDTO));
	}

	@PostMapping("/update")
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	public ResponseEntity<String> updateDermatologistInfo(@RequestBody DermatologistDTO dermatologistDTO) {
		try {
			dermatologistService.update(dermatologistDTO);
			return new ResponseEntity<>("Profile successfully updated!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updatePassword")
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	public ResponseEntity<String> updateDermatologistPassword(@RequestBody DermatologistDTO dermatologistDTO) {
		try {
			dermatologistService.updatePassword(dermatologistDTO);
			return new ResponseEntity<>("Profile successfully updated!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}

	  @PostMapping("/register")
	  @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
	  public ResponseEntity<String> registerDermatologist(@RequestBody DermatologistDTO userRequest) {
		  
	        if(!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
	            throw new IllegalArgumentException("Please make sure your password and confirmed password match!");
	        }
	        Person existingUser = dermatologistService.findByEmail(userRequest.getEmail());
	        if (existingUser != null) {
	            throw new ResourceConflictException("Entered email already exists", "Email already exists");
	        }
	        return new ResponseEntity<>("Dermatologist is successfully registred!", HttpStatus.CREATED);
	    }
	
}
