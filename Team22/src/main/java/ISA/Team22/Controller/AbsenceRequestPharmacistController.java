package ISA.Team22.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Service.AbsenceRequestPharmacistService;

@RestController
@RequestMapping(value = "/api/absencePharmacist", produces = MediaType.APPLICATION_JSON_VALUE)
public class AbsenceRequestPharmacistController {

	
	private final AbsenceRequestPharmacistService absenceRequestPharmacistService;
	
	@Autowired
	public AbsenceRequestPharmacistController(AbsenceRequestPharmacistService absenceRequestPharmacistService) {
		super();
		this.absenceRequestPharmacistService = absenceRequestPharmacistService;
	}
	
	
	
}
