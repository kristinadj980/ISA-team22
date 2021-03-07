package ISA.Team22.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ISA.Team22.Domain.Users.Dermatologist;


public interface DermatologistRepository extends JpaRepository<Dermatologist, Long>{
	
	 @Query(value = "SELECT * FROM dermatologist", nativeQuery = true)
	 Iterable<Dermatologist> getAllDermatologists();
	 
	 Dermatologist findByEmail(String email);


}
