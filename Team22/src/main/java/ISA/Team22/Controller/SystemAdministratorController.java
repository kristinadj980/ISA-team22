package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.PersonRequestDTO;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Domain.Users.SystemAdministrator;
import ISA.Team22.Exception.ResourceConflictException;
import ISA.Team22.Service.SystemAdministratorService;

@RestController
@RequestMapping("/api/systemAdmin")
public class SystemAdministratorController {

	@Autowired
	private SystemAdministratorService systemAdministratorService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ROLE_SYSTEM_ADMINISTRATOR')")
    public ResponseEntity<String> registerUser(@RequestBody PersonRequestDTO userRequest) {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

        Person loggedUser =(Person)currentUser.getPrincipal();
        SystemAdministrator systemAdmin = systemAdministratorService.findById(loggedUser.getId());
        if(!systemAdmin.getMainAdmin()) {
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
}

