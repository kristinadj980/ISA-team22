package ISA.Team22.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team22.Domain.Users.Dermatologist;
import ISA.Team22.Domain.Users.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	Patient findByEmail(String email);

}
