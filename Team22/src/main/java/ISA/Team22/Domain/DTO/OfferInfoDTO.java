package ISA.Team22.Domain.DTO;

import java.time.LocalDate;
import java.util.List;


public class OfferInfoDTO {
	private Long offerId;
    private Long purchaseOrderId;
    private Integer deliveryTime;
    private Double totalPrice;
    private LocalDate date;
    private List<DrugOrderDTO> drugs;
    private String pharmacyName;
    private boolean changable;
    
	public OfferInfoDTO() {
		super();
	}

	public OfferInfoDTO(Long offerId, Long purchaseOrderId, Integer deliveryTime, Double totalPrice,
			LocalDate date, List<DrugOrderDTO> drugs, String pharmacyName, boolean changable) {
		super();
		this.offerId = offerId;
		this.purchaseOrderId = purchaseOrderId;
		this.deliveryTime = deliveryTime;
		this.totalPrice = totalPrice;
		this.date = date;
		this.drugs = drugs;
		this.pharmacyName = pharmacyName;
		this.changable = changable;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Integer getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<DrugOrderDTO> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<DrugOrderDTO> drugs) {
		this.drugs = drugs;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public boolean isChangable() {
		return changable;
	}

	public void setChangable(boolean changable) {
		this.changable = changable;
	}
    
    

}
