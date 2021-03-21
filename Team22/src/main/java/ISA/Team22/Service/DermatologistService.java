package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.Authority;
import ISA.Team22.Domain.Users.City;
import ISA.Team22.Domain.Users.Country;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Repository.AuthorityRepository;
import ISA.Team22.Repository.DermatologistRepository;
import ISA.Team22.Service.IService.IDermatologistService;

@Service
public class DermatologistService implements IDermatologistService {

	private final DermatologistRepository dermatologistRepository;
	
	@Autowired
    private AuthorityService authService;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	public DermatologistService(DermatologistRepository dermatologistRepository) {
		this.dermatologistRepository = dermatologistRepository;
	}

	@Override
    public List<Dermatologist> getAllDermatologists() {
        return dermatologistRepository.findAll();
    }

	@Override
	public Dermatologist findByEmail(String email) {
		return dermatologistRepository.findByEmail(email);
	}

	@Override
	public Dermatologist save(DermatologistDTO userRequest) {
		Dermatologist dermatologist =  new Dermatologist();
        dermatologist.setName(userRequest.getName());
        dermatologist.setLastName(userRequest.getSurname());
        AddressDTO addressDTO = userRequest.getAddress();
        City city = new City();
        city.setName(addressDTO.getTown());
        Country country = new Country();
        country.setName(addressDTO.getCountry());
        city.setCountry(country);
        Address address = new Address(addressDTO.getStreet(),addressDTO.getNumber(),city);
        dermatologist.setAddress(address);
        dermatologist.setEmail(userRequest.getEmail());
        dermatologist.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        dermatologist.setFirstLogged(true);
        Authority authorityDermatologist = authService.findByname("ROLE_DERMATOLOGIST");
        List<Authority> auth = new ArrayList<Authority>();
        if(authorityDermatologist==null) {
            authorityRepository.save(new Authority("ROLE_DERMATOLOGIST"));
            auth.add(authService.findByname("ROLE_DERMATOLOGIST"));
        }
        else {
            auth.add(authorityDermatologist);
        }
        dermatologist.setAuthorities(auth);
        dermatologist.setEnabled(true);
        return dermatologistRepository.save(dermatologist);
	}

	@Override
	public Dermatologist getById(Long id) {
		 return dermatologistRepository.findById(id).get();
	}

	@Override
	public void update(DermatologistDTO userDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AddressDto addressDto = userDto.getAddress();

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAddress(new Address(addressDto.getCountry(), addressDto.getStreet(), addressDto.getCity()));

        userRepository.save(user);
    }
}
