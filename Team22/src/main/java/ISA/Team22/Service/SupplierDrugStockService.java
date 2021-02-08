package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.SupplierDrugStockRepository;
import ISA.Team22.Service.IService.ISupplierDrugStockService;

@Service
public class SupplierDrugStockService implements ISupplierDrugStockService {

	@Autowired
	private SupplierDrugStockRepository supplierDrugStockRepository;
}
