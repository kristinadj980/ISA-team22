package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
