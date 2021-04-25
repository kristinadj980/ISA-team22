package ISA.Team22.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.DrugOrderDTO;
import ISA.Team22.Domain.DTO.OrdersReviewDTO;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.Pharmacy.PurchaseOrderStatus;
import ISA.Team22.Domain.PharmacyWorkflow.PurchaseOrderDrug;
import ISA.Team22.Service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchaseOrder")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseOrderController {
	
	private final PurchaseOrderService purchaseOrderService;
	
	@Autowired
	public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@GetMapping("activeOrders")
    @PreAuthorize("hasRole('SUPPLIER')")
	ResponseEntity<List<OrdersReviewDTO>> getActiveOrders(){
		List<PurchaseOrder> purchaseOrders = purchaseOrderService.findAllOrders();
		List<OrdersReviewDTO> ordersReviewDTOs = new ArrayList<OrdersReviewDTO>();
		for (PurchaseOrder purchaseOrder : purchaseOrders) {
			if(purchaseOrder.getDueDate().isAfter(LocalDate.now()) && !purchaseOrder.getPurchaseOrderStatus().equals(PurchaseOrderStatus.closed)){
				OrdersReviewDTO dto = new OrdersReviewDTO(purchaseOrder.getId(), purchaseOrder.getDueDate(), purchaseOrder.getPurchaseOrderStatus().toString(), findDrugs(purchaseOrder.getPurchaseOrderDrugs()),
						purchaseOrder.getPharmacyAdministrator().getPharmacy().getName());
				ordersReviewDTOs.add(dto);
				
			}
		}
		 return ordersReviewDTOs == null ?
	                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
	                ResponseEntity.ok(ordersReviewDTOs);
	}

	private List<DrugOrderDTO> findDrugs(List<PurchaseOrderDrug> drugOrderDTOs) {
		List<DrugOrderDTO> drugs = new ArrayList<>();
		for (PurchaseOrderDrug d : drugOrderDTOs) {
			DrugOrderDTO orderDTO = new DrugOrderDTO(d.getId(), d.getDrug().getName(), d.getDrug().getCode(), 
					d.getDrug().getDrugForm(), d.getDrug().getDrugType(), d.getAmount());
			drugs.add(orderDTO);
		}
		
		return drugs;
	}
}
