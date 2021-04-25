package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;
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
		this.pharmacyRepository = pharmacyRepository;
	}

	/*@Override
	public Pharmacy save(PharmacyDTO pharmacy) {
		System.out.println("****************************");
		System.out.println(pharmacy.getName());
		System.out.println(pharmacy.getDescription());
		System.out.println(pharmacy.getAddressDTO());
		System.out.println("*************************");
		Pharmacy p = new Pharmacy();
		p.setName(pharmacy.getName());
		AddressDTO dto = pharmacy.getAddressDTO();
        City city = new City();
        city.setName(dto.getTown());
        Country country = new Country();
        country.setName(dto.getCountry());
        city.setCountry(country);
        Address address = new Address(dto.getStreet(),dto.getNumber(),city);
        p.setAddress(address);
        p.setDescription(pharmacy.getDescription());
        
        return pharmacyRepository.save(p);
	}*/
	
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
