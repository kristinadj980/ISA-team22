package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PersonRequestDTO;
import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.Authority;
import ISA.Team22.Domain.Users.City;
import ISA.Team22.Domain.Users.Country;
import ISA.Team22.Domain.Users.SystemAdministrator;
import ISA.Team22.Repository.AuthorityRepository;
import ISA.Team22.Repository.SystemAdministratorRepository;
import ISA.Team22.Service.IService.ISystemAdministratorService;

@Service
public class SystemAdministratorService implements ISystemAdministratorService {

	@Autowired
	private SystemAdministratorRepository systemAdministratorRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public SystemAdministrator findById(Long id) {
		return systemAdministratorRepository.findById(id).get();
	}

	@Override
	public SystemAdministrator findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemAdministrator> findAll() {
		return systemAdministratorRepository.findAll();
	}

	@Override
	public SystemAdministrator save(PersonRequestDTO userRequest) {
		SystemAdministrator systemAdministrator =  new SystemAdministrator();
        systemAdministrator.setName(userRequest.getName());
        systemAdministrator.setLastName(userRequest.getSurname());
        AddressDTO addressDTO = userRequest.getAddress();
        City city = new City();
        city.setName(addressDTO.getTown());
        Country country = new Country();
        country.setName(addressDTO.getCountry());
        city.setCountry(country);
        Address address = new Address(addressDTO.getStreet(),addressDTO.getNumber(),city);
        systemAdministrator.setAddress(address);
        systemAdministrator.setEmail(userRequest.getEmail());
        systemAdministrator.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        systemAdministrator.setFirstLogged(true);
        systemAdministrator.setContact(userRequest.getPhoneNumber());
        Authority authoritySystemAdmin =  authorityService.findByname("ROLE_SYSTEM_ADMINISTRATOR");
        List<Authority> auth = new ArrayList<Authority>();
        if(authoritySystemAdmin==null) {
            authorityRepository.save(new Authority("ROLE_SYSTEM_ADMINISTRATOR"));
            auth.add((Authority) authorityService.findByname("ROLE_SYSTEM_ADMINISTRATOR"));
        }
        else {
            auth.add(authoritySystemAdmin);
        }
        systemAdministrator.setAuthorities(auth);
        systemAdministrator.setEnabled(true);
        systemAdministrator.setMainAdmin(false);
        return systemAdministratorRepository.save(systemAdministrator);
	}

}
