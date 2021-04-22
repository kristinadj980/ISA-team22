package ISA.Team22.Service.IService;

import ISA.Team22.Domain.DTO.OfferDTO;
import ISA.Team22.Domain.Pharmacy.Offer;

public interface IOfferService {
	Offer save(OfferDTO offerDTO);
}
