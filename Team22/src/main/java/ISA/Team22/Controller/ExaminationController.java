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
import ISA.Team22.Service.ExaminationService;

@RestController
@RequestMapping(value = "/api/examination", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExaminationController {

	
	private final ExaminationService examinationService;
	
	@Autowired
	public ExaminationController(ExaminationService examinationService) {
		this.examinationService = examinationService;
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
	public List<Examination> getFreeScheduledExaminations(){
		System.out.println("Pogodjen kontroler za dobavljanje zakazanih pregleda");
		Dermatologist dermatologist = (Dermatologist) SecurityContextHolder.getContext().getAuthentication();
		System.out.println(dermatologist.getId());
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		List<Examination> examinations = new ArrayList<Examination>();
		Person person = (Person) currentUser.getPrincipal();
		
		return examinations;
	}
}
