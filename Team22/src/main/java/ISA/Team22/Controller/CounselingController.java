package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.CounselingDTO;
import ISA.Team22.Service.CounselingService;

@RestController
@RequestMapping(value = "/api/counseling", produces = MediaType.APPLICATION_JSON_VALUE)
public class CounselingController {

	
	private final CounselingService counselingService;
	
	@Autowired
	public CounselingController(CounselingService counselingService) {
		super();
		this.counselingService = counselingService;
	}
	
	
	@PostMapping("/schedule")
	@PreAuthorize("hasRole('ROLE_PHARMACIST')")
	public ResponseEntity<String> scheduleCounselling(@RequestBody CounselingDTO counselingDTO) {
		try {
			String response = counselingService.scheduleCounselling(counselingDTO);
			System.out.println(response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
}
