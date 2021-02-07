package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.OfferRepository;
import ISA.Team22.Service.IService.IOfferService;

@Service
public class OfferService implements IOfferService {

	@Autowired
	private  OfferRepository offerRepository;
}
