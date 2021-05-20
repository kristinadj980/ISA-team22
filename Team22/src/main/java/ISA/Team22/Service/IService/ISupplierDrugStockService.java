package ISA.Team22.Service.IService;

import ISA.Team22.Domain.DTO.OfferDTO;
import ISA.Team22.Domain.DTO.SupplierDrugUpdateDTO;
import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;

public interface ISupplierDrugStockService {
	SupplierDrugStock update(SupplierDrugUpdateDTO supplierDrugUpdateDTO);
	Boolean updateAmount(OfferDTO offerDTO);
}
