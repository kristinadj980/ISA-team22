package ISA.Team22.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.DTO.PersonRequestDTO;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Service.PersonService;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
		// Ukoliko nema, server ce vratiti gresku 403 Forbidden
		// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
		@GetMapping("/person/{personId}")
		@PreAuthorize("hasRole('ADMIN')")
		public Person loadById(@PathVariable Long personId) {
			return this.personService.findById(personId);
		}

		@GetMapping("/user/all")
		@PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
		public List<Person> loadAll() {
			return this.personService.findAll();
		}
		
		@GetMapping(value = "/me")
		@PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')" + "||" + "hasRole('PHARMACY_ADMIN')" + "||" + "hasRole('PATIENT')" + "||"
				+ "hasRole('PHARMACIST')" + "||" + "hasRole('DERMATOLOGIST')" + "||" + "hasRole('DEALER')")
		public Person getMe(Authentication auth) {
			return personService.findById(((Person) auth.getPrincipal()).getId());
		}
		
		 @PostMapping("/update")
		 @PreAuthorize("hasAnyRole('SYSTEM_ADMINISTRATOR','PHARMACY_ADMIN','PATIENT','PHARMACIST','DERMATOLOGIST','DEALER')")
		 public ResponseEntity<String> updatePersonInfo(@RequestBody PersonRequestDTO personDTO) {
			 try {
				 personService.save(personDTO);
		         return new ResponseEntity<>("Profile successfully updated!", HttpStatus.OK);
		     } catch (Exception e) {
		         return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		     }
		}
}
