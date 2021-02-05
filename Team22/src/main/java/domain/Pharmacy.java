package domain;

import java.util.List;

public class Pharmacy {
	private String name;
	private String description;
	private int allGrades;
	private int numberOfGrades;
	private List<Long> subscribedUsersIDs;
	private List<Pharmacist> pharmacist;
	private List<Dermatologist> dermatologist;
	private Address address;
	//public PharmacyInventory pharmacyInventory;
	//public List<PharmacyAdministrator> pharmacyAdministrator;
}
