package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.PersonRequest;
import ISA.Team22.Domain.Users.Person;

public interface IPersonService {
	 Person findById(Long id);
	 Person  findByUsername(String username);
	 List<Person > findAll ();
	 Person  save(PersonRequest personRequest);
}
