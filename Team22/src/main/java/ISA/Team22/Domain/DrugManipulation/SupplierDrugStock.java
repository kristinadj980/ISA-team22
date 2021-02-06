package ISA.Team22.Domain.DrugManipulation;
import ISA.Team22.Domain.Users.Supplier;

public class SupplierDrugStock {
	
    private int quantity;
    private int reservedQuantity;
    private String name;
    private long code;
    private Supplier supplier;
    
	public SupplierDrugStock() {
		super();
	}

	public SupplierDrugStock(int quantity, int reservedQuantity, String name, long code, Supplier supplier) {
		super();
		this.quantity = quantity;
		this.reservedQuantity = reservedQuantity;
		this.name = name;
		this.code = code;
		this.supplier = supplier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReservedQuantity() {
		return reservedQuantity;
	}

	public void setReservedQuantity(int reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

    
    
}
