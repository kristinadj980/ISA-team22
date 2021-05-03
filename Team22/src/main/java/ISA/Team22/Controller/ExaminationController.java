package ISA.Team22.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import ISA.Team22.Domain.DTO.ExaminationDTO;
import ISA.Team22.Domain.Examination.Examination;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Person;
import ISA.Team22.Service.DermatologistService;
import ISA.Team22.Service.ExaminationService;

@RestController
@RequestMapping(value = "/api/examination", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExaminationController {

	
	private final ExaminationService examinationService;
	private final DermatologistService dermatologistService;
	
	@Autowired
	public ExaminationController(ExaminationService examinationService, DermatologistService dermatologistService) {
		this.examinationService = examinationService;
		this.dermatologistService = dermatologistService;
	}
	
	@PostMapping("/dermatologistSchedule")
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	public ResponseEntity<String> scheduleNewExamination(@RequestBody ExaminationDTO examinationDTO) {
		try {
			examinationService.scheduleNewExamination(examinationDTO);
			return new ResponseEntity<>("Examination successfully scheduled!", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getFreeScheduled")
	@PreAuthorize("hasRole('DERMATOLOGIST')")
	public ResponseEntity<List<ExaminationDTO>> getFreeScheduledExaminations(){
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		Person person = (Person) currentUser.getPrincipal();
		List<ExaminationDTO> examinationsDTO = examinationService.getFreeScheduledExaminations(person.getId());
		
		return examinationsDTO == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(examinationsDTO);
	}

}