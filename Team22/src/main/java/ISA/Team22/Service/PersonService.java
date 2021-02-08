package ISA.Team22.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.PersonRequest;
import ISA.Team22.Domain.Users.Authority;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Repository.PersonRepository;
import ISA.Team22.Service.IService.IPersonService;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;


	@Override
	public Person findById(Long id) {
		Person p = personRepository.findById(id).orElseGet(null);
		return p;
	}

	@Override
	public Person findByUsername(String username) {
		Person p = personRepository.findByUsername(username);
		return p;
	}

	@Override
	public List<Person> findAll() {
		List<Person> result = personRepository.findAll();
		return result;
	}

	@Override
	public Person save(PersonRequest personRequest) {
		Person p = new Person();
		p.setUserName(personRequest.getUsername());
		// pre nego sto postavimo lozinku u atribut hesiramo je
		p.setPassword(passwordEncoder.encode(personRequest.getPassword()));
		p.setName(personRequest.getFirstname());
		p.setLastName(personRequest.getLastname());
		
		
		List<Authority> auth = authService.findByname("ROLE_USER");
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		p.setAuthorities(auth);
		
		p = this.personRepository.save(p);
		return p;
	}
	
	
}
