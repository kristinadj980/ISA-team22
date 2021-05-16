package ISA.Team22.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.PatientFrontDTO;
import ISA.Team22.Domain.Users.Patient;
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
	
	
}
