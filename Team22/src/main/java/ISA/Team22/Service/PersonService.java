package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PersonRepository;
import ISA.Team22.Service.IService.IPersonService;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository personRepository;
}
