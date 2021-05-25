package ISA.Team22.Domain.DTO;

public class DrugAlternativeDTO {

	private Long drugId;
	private Long examinationId;

	public DrugAlternativeDTO() {
		super();
	}
	
	public DrugAlternativeDTO(Long drugId, Long examinationId) {
		super();
		this.drugId = drugId;
		this.examinationId = examinationId;
	}
	

	public Long getDrugId() {
		return drugId;
	}


	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}


	public Long getExaminationId() {
		return examinationId;
	}


	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}

}
