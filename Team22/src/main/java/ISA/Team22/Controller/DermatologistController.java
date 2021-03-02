package ISA.Team22.Controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team22.Domain.DTO.DermatologistDTO;
import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Service.DermatologistService;

@RestController
@RequestMapping(value = "/dermatologist", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistController {
	
	private final DermatologistService dermatologistService;

	@Autowired
	public DermatologistController(DermatologistService dermatologistService) {
		this.dermatologistService = dermatologistService;
	}
	
	@GetMapping(value = "/getAllDermatologists")
    public ResponseEntity<List<DermatologistDTO>> getAllDermatologists() {
        List<Dermatologist> dermatologists = dermatologistService.getAllDermatologists();
        List<DermatologistDTO> dermatologistDto = new ArrayList<DermatologistDTO>();
        for(int i=0; i < dermatologists.size(); i++) {
        Dermatologist d = dermatologists.get(i);
        DermatologistDTO dermatologist = new DermatologistDTO(d.getName(), d.getLastName(), d.getEmail(), d.getAddress().toString());
        dermatologistDto.add(dermatologist);
        }
		return ResponseEntity.ok(dermatologistDto);
    }
	
	
}
