package ISA.Team22.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.AddressDTO;
import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.DTO.PersonRequestDTO;
import ISA.Team22.Domain.DTO.SystemAdminDTO;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.SystemAdministrator;
import ISA.Team22.Exception.ResourceConflictException;
import ISA.Team22.Service.DermatologistService;
import ISA.Team22.Service.SystemAdministratorService;

@RestController
@RequestMapping("/api/systemAdmin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SystemAdministratorController {

	
	private final SystemAdministratorService systemAdministratorService;
	
	@Autowired
	public SystemAdministratorController(SystemAdministratorService systemAdministratorService) {
		this.systemAdministratorService = systemAdministratorService;
	}

    @PostMapping("/register")
    @PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
    public ResponseEntity<String> registerSystemAdmin(@RequestBody PersonRequestDTO userRequest) {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

        Person loggedUser =(Person)currentUser.getPrincipal();
        SystemAdministrator systemAdministrator = systemAdministratorService.findById(loggedUser.getId());
        if(!systemAdministrator.getMainAdmin()) {
            throw new IllegalArgumentException("Only main system admin can register new system admin!");
        }


        Person existingUser = systemAdministratorService.findByEmail(userRequest.getEmail());
        if (existingUser != null) {
            throw new ResourceConflictException("Entered email already exists", "Email already exists");
        }
        if(userRequest.getPassword().isEmpty() || userRequest.getConfirmPassword().isEmpty()) {
            throw new IllegalArgumentException("Please fill all the required fields!");
        }
        if(!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            throw new IllegalArgumentException("Please make sure your password and rewrite password match!");
        }

        Person user = systemAdministratorService.save(userRequest);
        return new ResponseEntity<>("System administrator is successfully registred!", HttpStatus.CREATED);
    }
    
    @GetMapping("/profile")
	@PreAuthorize("hasRole('SYSTEM_ADMINISTRATOR')")
	public ResponseEntity<SystemAdminDTO> getMyAccount() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		SystemAdministrator admin = systemAdministratorService.findById(person.getId());
		System.out.println("************************");
		System.out.println(admin.getName());
		System.out.println(admin.getLastName());
		System.out.println(admin.getEmail());
		AddressDTO addressDto = new AddressDTO(admin.getAddress().getCity().getName(),
				admin.getAddress().getStreetName(), admin.getAddress().getStreetNumber(),
				admin.getAddress().getCity().getCountry().getName());
		SystemAdminDTO adminDTO = new SystemAdminDTO(admin.getName(), admin.getLastName(),
				admin.getEmail(), addressDto, admin.getPassword());
		System.out.println("****************************");
		return (ResponseEntity<SystemAdminDTO>) (admin == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(adminDTO));
	}
    
}

