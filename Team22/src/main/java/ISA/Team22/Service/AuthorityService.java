package ISA.Team22.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ISA.Team22.Domain.Users.Authority;
import ISA.Team22.Repository.AuthorityRepository;
import ISA.Team22.Service.IService.IAuthorityService;

public class AuthorityService implements IAuthorityService{
	 @Autowired
	  private AuthorityRepository authorityRepository;

	  @Override
	  public List<Authority> findById(Long id) {
	    Authority auth = this.authorityRepository.getOne(id);
	    List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    return auths;
	  }

	  @Override
	  public List<Authority> findByname(String name) {
	    Authority auth = this.authorityRepository.findByName(name);
	    List<Authority> auths = new ArrayList<>();
	    auths.add(auth);
	    return auths;
	  }
}
