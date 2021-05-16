package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.PharmacyBasicDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.City;
import ISA.Team22.Domain.Users.Country;
import ISA.Team22.Repository.PharmacyRepository;
import ISA.Team22.Service.IService.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

	private final PharmacyRepository pharmacyRepository;
	
	@Autowired
	public PharmacyService(PharmacyRepository pharmacyRepository) {
		super();
		this.pharmacyRepository = pharmacyRepository;
	}

	@Override
	public List<PharmacyBasicDTO> getAllPharmacyDermatolgist(Long id) {
		List<Pharmacy> pharmacies = pharmacyRepository.getAllPharmacyDermatolgist(id);
		List<PharmacyBasicDTO> pharmaciesDTO = new ArrayList<PharmacyBasicDTO>();
		for(Pharmacy p: pharmacies)
			pharmaciesDTO.add(new PharmacyBasicDTO(p.getId(), p.getName()));
		
		return pharmaciesDTO;
	}

	@Override
	public Pharmacy getById(Long id) {
		 return pharmacyRepository.findById(id).get();
	}
	
	@Override
    public Pharmacy save(PharmacyDTO pharmacy) {
        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.setName(pharmacy.getName());
        pharmacy1.setDescription(pharmacy.getDescription());
        AddressDTO addressDTO = pharmacy.getAddressDTO();
        City city = new City();
        city.setName(addressDTO.getTown());
        Country country = new Country();
        country.setName(addressDTO.getCountry());
        city.setCountry(country);
        Address address = new Address(addressDTO.getStreet(),addressDTO.getNumber(),city);
        pharmacy1.setAddress(address);
        

        return pharmacyRepository.save(pharmacy1);
    }
}
