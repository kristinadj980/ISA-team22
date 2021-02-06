package ISA.Team22.Domain.Pharmacy;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Pharmacist;
import ISA.Team22.Domain.Users.PharmacyAdministrator;

@Entity
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",  nullable = false)
	private String name;
	
	@Column(name = "description",  nullable = false)
	private String description;
	
	@Column(name = "allGrades")
	private Integer allGrades;
	
	@Column(name = "numberOfGrades")
	private Integer numberOfGrades;
	
	private List<Long> subscribedUsersIDs;
	private List<Pharmacist> pharmacist;
	private List<Dermatologist> dermatologist;
	private Address address;
	private PharmacyInventory pharmacyInventory;
	private List<PharmacyAdministrator> pharmacyAdministrator;
	
	public Pharmacy() {
		super();
	}

	public Pharmacy(Long id, String name, String description, Integer allGrades, Integer numberOfGrades, List<Long> subscribedUsersIDs,
			List<Pharmacist> pharmacist, List<Dermatologist> dermatologist, Address address,
			PharmacyInventory pharmacyInventory, List<PharmacyAdministrator> pharmacyAdministrator) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.allGrades = allGrades;
		this.numberOfGrades = numberOfGrades;
		this.subscribedUsersIDs = subscribedUsersIDs;
		this.pharmacist = pharmacist;
		this.dermatologist = dermatologist;
		this.address = address;
		this.pharmacyInventory = pharmacyInventory;
		this.pharmacyAdministrator = pharmacyAdministrator;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAllGrades() {
		return allGrades;
	}

	public void setAllGrades(Integer allGrades) {
		this.allGrades = allGrades;
	}

	public Integer getNumberOfGrades() {
		return numberOfGrades;
	}

	public void setNumberOfGrades(Integer numberOfGrades) {
		this.numberOfGrades = numberOfGrades;
	}

	public List<Long> getSubscribedUsersIDs() {
		return subscribedUsersIDs;
	}

	public void setSubscribedUsersIDs(List<Long> subscribedUsersIDs) {
		this.subscribedUsersIDs = subscribedUsersIDs;
	}

	public List<Pharmacist> getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(List<Pharmacist> pharmacist) {
		this.pharmacist = pharmacist;
	}

	public List<Dermatologist> getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(List<Dermatologist> dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PharmacyInventory getPharmacyInventory() {
		return pharmacyInventory;
	}

	public void setPharmacyInventory(PharmacyInventory pharmacyInventory) {
		this.pharmacyInventory = pharmacyInventory;
	}

	public List<PharmacyAdministrator> getPharmacyAdministrator() {
		return pharmacyAdministrator;
	}

	public void setPharmacyAdministrator(List<PharmacyAdministrator> pharmacyAdministrator) {
		this.pharmacyAdministrator = pharmacyAdministrator;
	}
	
	
	
}
