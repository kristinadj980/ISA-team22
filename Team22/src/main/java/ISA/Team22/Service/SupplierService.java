package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.SupplierRepository;
import ISA.Team22.Service.IService.ISupplierService;

@Service
public class SupplierService implements ISupplierService  {

	@Autowired
	private SupplierRepository supplierRepository;
}
