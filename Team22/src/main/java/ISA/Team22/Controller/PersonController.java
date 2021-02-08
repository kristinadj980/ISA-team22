package ISA.Team22.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		@PreAuthorize("hasRole('ADMIN')")
		public List<Person> loadAll() {
			return this.personService.findAll();
		}
}
