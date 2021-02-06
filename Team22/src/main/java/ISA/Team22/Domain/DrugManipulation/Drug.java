package ISA.Team22.Domain.DrugManipulation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Examination.IssuanceRegime;

@Entity
public class Drug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",  nullable = false)
	private String name;
	
	@Column(name = "code", unique = true, nullable = false)
	private Long code;
	
	@Column(name = "producer", nullable = false)
	private String producer;
	
	@Enumerated(EnumType.ORDINAL)
	private DrugType drugType;
	
	@Enumerated(EnumType.ORDINAL)
	private DrugForm drugForm;
	
	@Enumerated(EnumType.ORDINAL)
	private IssuanceRegime issuance;
	
	@Column(name = "note", nullable = false)
	private String note;
	
	@Column(name = "numberOfGrades", nullable = false)
	private Integer numberOfGrades;
	
	@Column(name = "allGrades", nullable = false)
	private Integer allGrades;
	
	
	private DrugSpecification drugSpecification;
	
	public Drug() {
		super();
	}
	public Drug(Long id, String name, Long code, String producer, DrugType drugType, DrugForm drugForm, IssuanceRegime issuance,
			String note, Integer numberOfGrades, Integer allGrades, DrugSpecification drugSpecification) {
		super();
		this.id = id;
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
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
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
	public Integer getNumberOfGrades() {
		return numberOfGrades;
	}
	public void setNumberOfGrades(Integer numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}
	public Integer getAllGrades() {
		return allGrades;
	}
	public void setAllGrades(Integer allGrades) {
		this.allGrades = allGrades;
	}
	public DrugSpecification getDrugSpecification() {
		return drugSpecification;
	}
	public void setDrugSpecification(DrugSpecification drugSpecification) {
		this.drugSpecification = drugSpecification;
	}
	
}
