package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ISA.Team22.Domain.DTO.SupplierDrugUpdateDTO;
import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Repository.SupplierDrugStockRepository;
import ISA.Team22.Service.IService.ISupplierDrugStockService;

@Service
public class SupplierDrugStockService implements ISupplierDrugStockService {

	private final SupplierDrugStockRepository supplierDrugStockRepository;
	
	@Autowired
	public SupplierDrugStockService(SupplierDrugStockRepository supplierDrugStockRepository) {
		this.supplierDrugStockRepository = supplierDrugStockRepository;
	}
	
	public SupplierDrugStock update(SupplierDrugUpdateDTO supplierDrugUpdateDTO) {
		SupplierDrugStock supplierDrugs = supplierDrugStockRepository.findById(supplierDrugUpdateDTO.getDrugId()).get();
		supplierDrugs.setQuantity(supplierDrugUpdateDTO.getNewQuantity());
		
        return supplierDrugStockRepository.save(supplierDrugs);
    }
	
}

