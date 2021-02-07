package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.PurchaseOrderRepository;
import ISA.Team22.Service.IService.IPurchaseOrderService;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
}
