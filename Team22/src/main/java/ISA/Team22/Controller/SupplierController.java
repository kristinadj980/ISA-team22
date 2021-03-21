package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.DTO.PersonRequestDTO;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Exception.ResourceConflictException;
import ISA.Team22.Service.DermatologistService;
import ISA.Team22.Service.SupplierService;

@RestController
@RequestMapping(value = "/api/supplier", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierController {

	private final SupplierService supplierService;

	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@PostMapping("/register")
	  @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
	  public ResponseEntity<String> registerSupplier(@RequestBody PersonRequestDTO userRequest) {
		   
	        if(!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
	            throw new IllegalArgumentException("Please make sure your password and confirmed password match!");
	        }
	        Person existingUser = supplierService.findByEmail(userRequest.getEmail());
	        if (existingUser != null) {
	            throw new ResourceConflictException("Entered email already exists", "Email already exists");
	        }
	        Person user = supplierService.save(userRequest);
	        return new ResponseEntity<>("Supplier is successfully registred!", HttpStatus.CREATED);
	    }
	
}
