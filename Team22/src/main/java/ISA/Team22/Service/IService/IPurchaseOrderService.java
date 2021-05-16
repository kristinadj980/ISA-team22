package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.Pharmacy.PurchaseOrder;

public interface IPurchaseOrderService {
	List<PurchaseOrder> findAllOrders();
}
