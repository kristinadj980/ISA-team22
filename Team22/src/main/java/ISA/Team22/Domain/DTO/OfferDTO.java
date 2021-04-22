package ISA.Team22.Domain.DTO;

import java.time.LocalDate;

public class OfferDTO {
	private Long supplierId;
    private Long orderId;
    private LocalDate deliveryDate;
    private double price;
    
	public OfferDTO() {
		super();
	}

	public OfferDTO(Long supplierId, Long orderId, LocalDate deliveryDate, double price) {
		super();
		this.supplierId = supplierId;
		this.orderId = orderId;
		this.deliveryDate = deliveryDate;
		this.price = price;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
}
