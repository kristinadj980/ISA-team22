package ISA.Team22.Domain.DrugManipulation;

import ISA.Team22.Domain.Examination.IssuanceRegime;

public class Drug {
	private String name;
	private long code;
	private String producer;
	private DrugType drugType;
	private DrugForm drugForm;
	private IssuanceRegime issuance;
	private String note;
	private int numberOfGrades;
	private int allGrades;
	private DrugSpecification drugSpecification;
	
	public Drug() {
		super();
	}
	public Drug(String name, long code, String producer, DrugType drugType, DrugForm drugForm, IssuanceRegime issuance,
			String note, int numberOfGrades, int allGrades, DrugSpecification drugSpecification) {
		super();
		this.name = name;
		this.code = code;
		this.producer = producer;
		this.drugType = drugType;
		this.drugForm = drugForm;
		this.issuance = issuance;
		this.note = note;
		this.numberOfGrades = numberOfGrades;
		this.allGrades = allGrades;
		this.drugSpecification = drugSpecification;
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
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public DrugType getDrugType() {
		return drugType;
	}
	public void setDrugType(DrugType drugType) {
		this.drugType = drugType;
	}
	public DrugForm getDrugForm() {
		return drugForm;
	}
	public void setDrugForm(DrugForm drugForm) {
		this.drugForm = drugForm;
	}
	public IssuanceRegime getIssuance() {
		return issuance;
	}
	public void setIssuance(IssuanceRegime issuance) {
		this.issuance = issuance;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getNumberOfGrades() {
		return numberOfGrades;
	}
	public void setNumberOfGrades(int numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}
	public int getAllGrades() {
		return allGrades;
	}
	public void setAllGrades(int allGrades) {
		this.allGrades = allGrades;
	}
	public DrugSpecification getDrugSpecification() {
		return drugSpecification;
	}
	public void setDrugSpecification(DrugSpecification drugSpecification) {
		this.drugSpecification = drugSpecification;
	}
	
}
