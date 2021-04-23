package ISA.Team22.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.OfferDTO;
import ISA.Team22.Domain.DTO.SupplierDrugUpdateDTO;
import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Domain.PharmacyWorkflow.PurchaseOrderDrug;
import ISA.Team22.Repository.PurchaseOrderRepository;
import ISA.Team22.Repository.SupplierDrugStockRepository;
import ISA.Team22.Service.IService.ISupplierDrugStockService;

@Service
public class SupplierDrugStockService implements ISupplierDrugStockService {

	private final SupplierDrugStockRepository supplierDrugStockRepository;
	
	private final PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	public SupplierDrugStockService(SupplierDrugStockRepository supplierDrugStockRepository,PurchaseOrderRepository purchaseOrderRepository) {
		this.supplierDrugStockRepository = supplierDrugStockRepository;
		this.purchaseOrderRepository = purchaseOrderRepository;
	}
	
	public SupplierDrugStock update(SupplierDrugUpdateDTO supplierDrugUpdateDTO) {
		SupplierDrugStock supplierDrugs = supplierDrugStockRepository.findById(supplierDrugUpdateDTO.getDrugId()).get();
		supplierDrugs.setQuantity(supplierDrugUpdateDTO.getNewQuantity());
		
        return supplierDrugStockRepository.save(supplierDrugs);
    }
	
	 public Boolean updateQuantities(OfferDTO offerDTO) {
	        List<PurchaseOrderDrug> orderDrugs = purchaseOrderRepository.findById(offerDTO.getOrderId()).get().getPurchaseOrderDrugs();
	        List<SupplierDrugStock> drugStocks = supplierDrugStockRepository.findAll();
	        for(PurchaseOrderDrug drug : orderDrugs) {
	            for (SupplierDrugStock supplierDrugStock : drugStocks) {
					if(drug.getDrug().getName().equals(supplierDrugStock.getName()) && (drug.getAmount() <= supplierDrugStock.getQuantity())){
						int newAmount = supplierDrugStock.getQuantity() - drug.getAmount();
						supplierDrugStock.setQuantity(newAmount);
						
						int newReservedQuantity = supplierDrugStock.getReservedQuantity() + drug.getAmount();

						supplierDrugStock.setReservedQuantity(newReservedQuantity);
						
						supplierDrugStockRepository.save(supplierDrugStock);
					}
				}
	        }
	       
	        return true;
	    }

	
}

