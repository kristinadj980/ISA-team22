package ISA.Team22.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.PatientFrontDTO;
import ISA.Team22.Domain.Users.Patient;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Service.PatientService;

@RestController
@RequestMapping(value = "/api/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	
	private final PatientService patientService;

	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@GetMapping("/allPatients")
	@PreAuthorize("hasRole('PATIENT')" + "||" + "hasRole('PHARMACIST')" + "||" + "hasRole('DERMATOLOGIST')")
    public ResponseEntity<List<PatientFrontDTO>> getAll() {
        List<PatientFrontDTO> patients = patientService.getAll();
       
        return patients == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(patients);
    }
	
	@GetMapping("/myAccount")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<Patient> getMyAccount() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) currentUser.getPrincipal();
        Patient patient = patientService.findById(person.getId());
        
        return patient == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(patient);
    }
	
	
}
