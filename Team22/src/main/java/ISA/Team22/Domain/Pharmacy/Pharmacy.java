package ISA.Team22.Domain.Pharmacy;

import java.util.List;

import ISA.Team22.Domain.Users.Address;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Pharmacist;
import ISA.Team22.Domain.Users.PharmacyAdministrator;

public class Pharmacy {
	private String name;
	private String description;
	private int allGrades;
	private int numberOfGrades;
	private List<Long> subscribedUsersIDs;
	private List<Pharmacist> pharmacist;
	private List<Dermatologist> dermatologist;
	private Address address;
	private PharmacyInventory pharmacyInventory;
	private List<PharmacyAdministrator> pharmacyAdministrator;
	
	public Pharmacy() {
		super();
	}

	public Pharmacy(String name, String description, int allGrades, int numberOfGrades, List<Long> subscribedUsersIDs,
			List<Pharmacist> pharmacist, List<Dermatologist> dermatologist, Address address,
			PharmacyInventory pharmacyInventory, List<PharmacyAdministrator> pharmacyAdministrator) {
		super();
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

	public int getAllGrades() {
		return allGrades;
	}

	public void setAllGrades(int allGrades) {
		this.allGrades = allGrades;
	}

	public int getNumberOfGrades() {
		return numberOfGrades;
	}

	public void setNumberOfGrades(int numberOfGrades) {
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
