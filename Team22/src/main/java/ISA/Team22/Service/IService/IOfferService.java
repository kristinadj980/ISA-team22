package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.DTO.OfferDTO;
import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Domain.Pharmacy.Offer;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.Users.Supplier;

public interface IOfferService {
	Offer save(OfferDTO offerDTO);
	Offer findById(Long id);
	Offer sendOffer(OfferDTO offerDTO);
	Boolean isOfferPossible(OfferDTO offerDTO, Supplier supplier);
	Boolean areDrugsAvailable(PurchaseOrder purchaseOrder, List<SupplierDrugStock> supplierDrugStocks);
	Offer changeOffer(OfferDTO offerDTO);
}
