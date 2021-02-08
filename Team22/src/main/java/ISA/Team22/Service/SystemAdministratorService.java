package ISA.Team22.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team22.Repository.SystemAdministratorRepository;
import ISA.Team22.Service.IService.ISystemAdministratorService;

@Service
public class SystemAdministratorService implements ISystemAdministratorService {

	@Autowired
	private SystemAdministratorRepository systemAdministratorRepository;
}
