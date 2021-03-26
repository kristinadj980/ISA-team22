package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PharmacistDTO;
import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.Authority;
import ISA.Team22.Domain.Users.City;
import ISA.Team22.Domain.Users.Country;
import ISA.Team22.Domain.Users.Pharmacist;
import ISA.Team22.Repository.AuthorityRepository;
import ISA.Team22.Repository.PharmacistRepository;
import ISA.Team22.Service.IService.IPharmacistService;

@Service
public class PharmacistService implements IPharmacistService {


	private final PharmacistRepository pharmacistRepository;
    private final AuthorityService authService;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
	
  
	@Autowired
	public PharmacistService(PharmacistRepository pharmacistRepository, AuthorityService authService, AuthorityRepository authorityRepository,
			PasswordEncoder passwordEncoder) {
		
		this.pharmacistRepository = pharmacistRepository;
		this.authService = authService;
		this.authorityRepository = authorityRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public Pharmacist getById(Long id) {
		return pharmacistRepository.findById(id).get();
	}

	@Override
	public Pharmacist findByEmail(String email) {
		return pharmacistRepository.findByEmail(email);
	}

	@Override
	public Pharmacist save(PharmacistDTO userRequest) {
		Pharmacist pharmacist =  new Pharmacist();
		pharmacist.setName(userRequest.getName());
		pharmacist.setLastName(userRequest.getSurname());
        AddressDTO addressDTO = userRequest.getAddress();
        City city = new City();
        city.setName(addressDTO.getTown());
        Country country = new Country();
        country.setName(addressDTO.getCountry());
        city.setCountry(country);
        Address address = new Address(addressDTO.getStreet(),addressDTO.getNumber(),city);
        pharmacist.setAddress(address);
        pharmacist.setEmail(userRequest.getEmail());
        pharmacist.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        pharmacist.setFirstLogged(true);
        Authority authorityDermatologist = authService.findByname("ROLE_PHARMACIST");
        List<Authority> auth = new ArrayList<Authority>();
        if(authorityDermatologist==null) {
            authorityRepository.save(new Authority("ROLE_PHARMACIST"));
            auth.add(authService.findByname("ROLE_PHARMACIST"));
        }
        else {
            auth.add(authorityDermatologist);
        }
        pharmacist.setAuthorities(auth);
        pharmacist.setEnabled(true);
        return pharmacistRepository.save(pharmacist);
	}

	@Override
	public void update(PharmacistDTO pharmacistDTO) {
		Pharmacist pharmacist = (Pharmacist) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    AddressDTO addressDTO = pharmacistDTO.getAddress();
	    City city = new City();
        city.setName(addressDTO.getTown());
        Country country = new Country();
        country.setName(addressDTO.getCountry());
        city.setCountry(country);
        
        pharmacist.setName(pharmacistDTO.getName());
        pharmacist.setLastName(pharmacistDTO.getSurname());
        pharmacist.setAddress(new Address(addressDTO.getCountry(), addressDTO.getStreet(), city));

        pharmacistRepository.save(pharmacist);
		
	}

	@Override
	public void updatePassword(PharmacistDTO pharmacistDTO) {
		Pharmacist pharmacist = (Pharmacist) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		pharmacist.setPassword(passwordEncoder.encode(pharmacistDTO.getConfirmPassword()));
		
		pharmacistRepository.save(pharmacist);
		
	}
}
