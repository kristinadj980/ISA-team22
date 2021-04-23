package ISA.Team22.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ISA.Team22.Domain.DTO.OfferDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.DrugManipulation.SupplierDrugStock;
import ISA.Team22.Domain.Pharmacy.Offer;
import ISA.Team22.Domain.Pharmacy.OfferStatus;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.PharmacyWorkflow.PurchaseOrderDrug;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.Supplier;
import ISA.Team22.Repository.OfferRepository;
import ISA.Team22.Repository.PurchaseOrderRepository;
import ISA.Team22.Repository.SupplierRepository;
import ISA.Team22.Service.IService.IOfferService;

@Service
public class OfferService implements IOfferService {

	private  final OfferRepository offerRepository;
	
	private final SupplierDrugStockService supplierDrugStockService;
	
	private final SupplierRepository supplierRepository;
	
	private final PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	public OfferService(OfferRepository offerRepository,SupplierDrugStockService supplierDrugStockService,
			SupplierRepository supplierRepository,PurchaseOrderRepository purchaseOrderRepository) {
		this.offerRepository = offerRepository;
		this.supplierDrugStockService = supplierDrugStockService;
		this.supplierRepository = supplierRepository;
		this.purchaseOrderRepository = purchaseOrderRepository;
	}
	
	public Offer sendOffer(OfferDTO offerDTO) {
		
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person)currentUser.getPrincipal();
        Supplier supplier = supplierRepository.findById(person.getId()).get();
        offerDTO.setSupplierId(supplier.getId());
       
        if(isOfferPossible(offerDTO, supplier))  {
            Boolean quantitiesUpdated = supplierDrugStockService.updateQuantities(offerDTO);
            Offer offer = save(offerDTO);
            Boolean canMakeOffer = isOfferPossible(offerDTO,supplier);
            System.out.println("KRAJJJJJJJJJJ");
            if(offer == null || !quantitiesUpdated || !canMakeOffer) {
            	return null;
            	}
            return offer;
        }
        return null;

    }
	
	private Boolean isOfferPossible(OfferDTO offerDTO, Supplier supplier) {
		if(offerDTO.getDeliveryDate().isAfter(offerDTO.getDueDate()) || offerDTO.getDeliveryDate() == null ) {
        	throw new IllegalArgumentException("Delivery date is passed!");
        }
        
        PurchaseOrder purchaseOrder ;
        try {
        	purchaseOrder = purchaseOrderRepository.findById(offerDTO.getOrderId()).get();
		} catch (Exception e) {
			throw new IllegalArgumentException("There is no order with that id!");
		}
       
        List<SupplierDrugStock> supplierDrugStocks = supplier.getDrugStocks();  //lista njegovih lekova
        if(!areDrugsAvailable(purchaseOrder, supplierDrugStocks)) {
        	throw new IllegalArgumentException("You don't have enough drugs in stock");
        }
        
        if(!purchaseOrder.getDueDate().isAfter(LocalDate.now()) || purchaseOrder.getPurchaseOrderStatus().equals("closed")) {
            throw new IllegalArgumentException("Creating offer is not possible. Order is closed.");
        }
       
        return true;
	}

	private Boolean areDrugsAvailable(PurchaseOrder purchaseOrder, List<SupplierDrugStock> supplierDrugStocks) {
		for (PurchaseOrderDrug drug : purchaseOrder.getPurchaseOrderDrugs()) {
			for (SupplierDrugStock supplierDrugStock : supplierDrugStocks) {
				if(drug.getDrug().getName().equals(supplierDrugStock.getName()) && (drug.getAmount() <= supplierDrugStock.getQuantity())){
					return true;
				}
				 else {
		                throw new IllegalArgumentException("You cant make offer for this order. You dont have enough drugs.");
		            }
			}
		}
		 return false;
	}

	@Override
	public Offer save(OfferDTO offerDTO) {
		System.out.println("################################3");
		Offer offer = new Offer();
		OfferStatus status = null ;
		System.out.println("ID:" + offerDTO.getSupplierId());
		offer.setSupplier(supplierRepository.findById(offerDTO.getSupplierId()).get());
		System.out.println("USPESNOOOO");
		offer.setDeliveryTime(offerDTO.getDeliveryDate());
		offer.setPurchaseOrder(purchaseOrderRepository.findById(offerDTO.getOrderId()).get());
        offer.setTotalPrice(offerDTO.getPrice());
        offer.setOfferStatus(status.created);
        System.out.println("################################3");
        return offerRepository.save(offer);
        
	}

	@Override
	public Offer findById(Long id) {
		// TODO Auto-generated method stub
		return  offerRepository.findById(id).get();
	}

	
}
