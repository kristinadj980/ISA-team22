package domain;

import java.util.Date;
import java.util.List;

public class DrugReservation {
	
	   private long resevationId;
	   private DrugStatus status;
	   private Date dueDate;	   
	   private Patient patient;
	   private List<PharmacyInventory> pharmacyInventory;

}
