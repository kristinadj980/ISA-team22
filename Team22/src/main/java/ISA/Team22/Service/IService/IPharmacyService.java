package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.PharmacyDTO;
import ISA.Team22.Domain.Pharmacy.Pharmacy;

public interface IPharmacyService {
    Pharmacy save(PharmacyDTO pharmacy);
    List<Pharmacy> findAll();
    Pharmacy findById(Long pharmacyId);
}
