package ISA.Team22.Domain.DTO;

public class DrugAvailabilityDTO {
	private Long drugId;
	private String drugCode;
	private Long pharmacyId;
	private String pharmacyName;
	private Double price;
	private Long examiantionID;
	
	public DrugAvailabilityDTO() {
		super();
	}
    

	public DrugAvailabilityDTO(Long drugId, String drugCode, Long pharmacyId, String pharmacyName, Double price) {
		super();
		this.drugId = drugId;
		this.drugCode = drugCode;
		this.pharmacyId = pharmacyId;
		this.pharmacyName = pharmacyName;
		this.price = price;
	}

	
	public DrugAvailabilityDTO(Long drugId, Long examiantionID) {
		super();
		this.drugId = drugId;
		this.examiantionID = examiantionID;
	}


	public String getDrugCode() {
		return drugCode;
	}


	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}


	public Long getDrugId() {
		return drugId;
	}



	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}



	public Long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Long getExamiantionID() {
		return examiantionID;
	}


	public void setExamiantionID(Long examiantionID) {
		this.examiantionID = examiantionID;
	}
	

}
