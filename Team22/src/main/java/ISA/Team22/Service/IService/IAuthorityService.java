package ISA.Team22.Service.IService;

import java.util.List;

import ISA.Team22.Domain.Users.Authority;


public interface IAuthorityService {
	List<Authority> findById(Long id);
	List<Authority> findByname(String name);
}
