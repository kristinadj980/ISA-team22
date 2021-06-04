package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Domain.DTO.DrugDTO;
import ISA.Team22.Domain.DTO.DrugReservationDTO;
import ISA.Team22.Domain.DTO.PatientFrontDTO;
import ISA.Team22.Domain.DrugManipulation.Drug;
import ISA.Team22.Domain.DrugManipulation.DrugReservation;
import ISA.Team22.Repository.DrugReservationRepository;
import ISA.Team22.Service.IService.IDrugReservationService;

@Service
public class DrugReservationService implements IDrugReservationService {


	private final DrugReservationRepository drugReservationRepository;
	private final DrugService drugService;

	@Autowired
	public DrugReservationService(DrugReservationRepository drugReservationRepository, DrugService drugService) {
		super();
		this.drugReservationRepository = drugReservationRepository;
		this.drugService = drugService;
	}

	@Override
	public DrugReservationDTO getDrugReservation(Long id) {
		DrugReservation drugRes = drugReservationRepository.findById(id).get();
		PatientFrontDTO patient = new PatientFrontDTO(drugRes.getPatient().getId(), drugRes.getPatient().getName(), 
				drugRes.getPatient().getLastName(), drugRes.getPatient().getEmail());
		Drug drug = drugService.findById(drugRes.getDrugId());
		DrugDTO drugDto = new DrugDTO(drugRes.getDrugId(), drug.getName());
		DrugReservationDTO drugReservationDTO = new DrugReservationDTO(drugRes.getResevationId(), drugRes.getStatus(), drugRes.getDueDate(), patient,
				drugRes.getPharmacyId(), drugDto);
		
		
		return drugReservationDTO;
	}
}
