package ISA.Team22.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Repository.PurchaseOrderRepository;
import ISA.Team22.Service.IService.IPurchaseOrderService;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {

	private final PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
	}

	@Override
	public List<PurchaseOrder> findAllOrders() {
		return purchaseOrderRepository.findAll();
	}
}
