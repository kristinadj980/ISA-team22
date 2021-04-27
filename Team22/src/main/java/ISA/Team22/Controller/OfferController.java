package ISA.Team22.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ISA.Team22.Domain.DTO.DrugOrderDTO;
import ISA.Team22.Domain.DTO.OfferDTO;
import ISA.Team22.Domain.DTO.OfferInfoDTO;
import ISA.Team22.Domain.Pharmacy.Offer;
import ISA.Team22.Domain.Pharmacy.PurchaseOrder;
import ISA.Team22.Domain.PharmacyWorkflow.PurchaseOrderDrug;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.Supplier;
import ISA.Team22.Repository.OfferRepository;
import ISA.Team22.Repository.SupplierRepository;
import ISA.Team22.Service.OfferService;
import ISA.Team22.Service.SupplierService;

@RestController
@RequestMapping("/api/offer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OfferController {

	private final OfferService offerService;
	
	private final SupplierService supplierService;
	
	private final SupplierRepository supplierRepository;
	
	@Autowired
	public OfferController(OfferService offerService, SupplierService supplierService,SupplierRepository supplierRepository) {
		this.offerService = offerService;
		this.supplierService = supplierService;
		this.supplierRepository = supplierRepository;
	}
	
	@GetMapping("/myOffers")
    @PreAuthorize("hasRole('SUPPLIER')")
    ResponseEntity<List<OfferInfoDTO>> getMyActiveOffers()
    {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person)currentUser.getPrincipal();
        Supplier supplier = supplierService.findById(person.getId());
        List<OfferInfoDTO> offersDto = getSupplierOffersInfoDTOS(supplier);

        return (ResponseEntity<List<OfferInfoDTO>>) (offersDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(offersDto));
    }
	
	private List<OfferInfoDTO> getSupplierOffersInfoDTOS(Supplier supplier) {
        List<OfferInfoDTO> supplierOffersDto = new ArrayList<>();
        List<Offer> offers =  supplier.getOffers();
        for (Offer o: offers) {
            PurchaseOrder order = o.getPurchaseOrder();
            if(order.getDueDate().isAfter(LocalDate.now()) && !order.getPurchaseOrderStatus().equals("processed") && order.getDueDate().isAfter(LocalDate.now()))
            {
                supplierOffersDto.add(new OfferInfoDTO(o.getId(), order.getId(), o.getDeliveryTime(), o.getTotalPrice(),
                        order.getDueDate(), getMedicationsInOrder(order.getPurchaseOrderDrugs()), order.getPharmacyAdministrator().getPharmacy().getName(),true, o.getOfferStatus()));
            }
            else {
                supplierOffersDto.add(new OfferInfoDTO(o.getId(), order.getId(), o.getDeliveryTime(), o.getTotalPrice(),
                        order.getDueDate(), getMedicationsInOrder(order.getPurchaseOrderDrugs()), order.getPharmacyAdministrator().getPharmacy().getName(),false,o.getOfferStatus()));
            }

        }

        return supplierOffersDto;
    }
	
	private List<DrugOrderDTO> getMedicationsInOrder(List<PurchaseOrderDrug> purchaseOrderDrugs) {
        List<DrugOrderDTO> drugs = new ArrayList<>();
        for (PurchaseOrderDrug drug: purchaseOrderDrugs) {
        	drugs.add(new DrugOrderDTO(drug.getId(), drug.getDrug().getName(),
        			drug.getDrug().getCode(),drug.getDrug().getDrugForm(),
        			drug.getDrug().getDrugType(),drug.getAmount()));
        }
        return drugs;
    }
	
	@GetMapping("/myOffers/{offerStatus}")
    @PreAuthorize("hasRole('SUPPLIER')")
    ResponseEntity<List<OfferInfoDTO>> getMyActiveOffersByStatus(@PathVariable String offerStatus)
    {	
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person)currentUser.getPrincipal();
        Supplier supplier = supplierService.findById(person.getId());
        List<OfferInfoDTO> offersDto = getOffersInfoDTOSByStatus(supplier,offerStatus);

        return offersDto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(offersDto);
    }

    private List<OfferInfoDTO> getOffersInfoDTOSByStatus(Supplier supplier, String offerStatus) {
        List<OfferInfoDTO> supplierOffersDto = new ArrayList<>();
        List<Offer> offers =  supplier.getOffers();
        for (Offer o: offers) {
            if(o.getOfferStatus().toString().equals(offerStatus)) {
                PurchaseOrder order = o.getPurchaseOrder();
                if(order.getDueDate().isAfter(LocalDate.now()) && !order.getPurchaseOrderStatus().equals("closed"))
                {
                	 supplierOffersDto.add(new OfferInfoDTO(o.getId(), order.getId(), o.getDeliveryTime(), o.getTotalPrice(),
                             order.getDueDate(), getMedicationsInOrder(order.getPurchaseOrderDrugs()), order.getPharmacyAdministrator().getPharmacy().getName(),true, o.getOfferStatus()));
                 }
                else {
                	supplierOffersDto.add(new OfferInfoDTO(o.getId(), order.getId(), o.getDeliveryTime(), o.getTotalPrice(),
                            order.getDueDate(), getMedicationsInOrder(order.getPurchaseOrderDrugs()), order.getPharmacyAdministrator().getPharmacy().getName(),true, o.getOfferStatus()));
                }
            }

        }
       
        return supplierOffersDto;
    }
    
    @PostMapping("/addOffer")
    @PreAuthorize("hasRole('SUPPLIER')")
    ResponseEntity<Offer> addOffer(@RequestBody OfferDTO offerDTO)
    {
        Offer offer = offerService.sendOffer(offerDTO);
       
        return offer == null  ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(offer);
    }
    
    @PostMapping("/changeOffer")
    @PreAuthorize("hasRole('SUPPLIER')")
    ResponseEntity<Offer> changeOffer(@RequestBody OfferDTO offerDTO)
    {
    	Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person)currentUser.getPrincipal();
        Supplier supplier = supplierRepository.findById(person.getId()).get();
        offerDTO.setSupplierId(supplier.getId());
   
        if(offerService.isOfferPossible(offerDTO, supplier)) {
        	Offer offer = offerService.changeOffer(offerDTO);
            return offer == null  ?
                    new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                    ResponseEntity.ok(offer);
        }
        return null;
        
    }
}
