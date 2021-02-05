package domain;

import java.util.List;

public class DrugSpecification {
	private String contraindications;
	private String therapy;
	private String compositions;
	private List<Long> substituteDrugCodes;
	
	public DrugSpecification() {
		super();
	}
	public DrugSpecification(String contraindications, String therapy, String compositions,
			List<Long> substituteDrugCodes) {
		super();
		this.contraindications = contraindications;
		this.therapy = therapy;
		this.compositions = compositions;
		this.substituteDrugCodes = substituteDrugCodes;
	}
	public String getContraindications() {
		return contraindications;
	}
	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}
	public String getTherapy() {
		return therapy;
	}
	public void setTherapy(String therapy) {
		this.therapy = therapy;
	}
	public String getCompositions() {
		return compositions;
	}
	public void setCompositions(String compositions) {
		this.compositions = compositions;
	}
	public List<Long> getSubstituteDrugCodes() {
		return substituteDrugCodes;
	}
	public void setSubstituteDrugCodes(List<Long> substituteDrugCodes) {
		this.substituteDrugCodes = substituteDrugCodes;
	}
	
}
