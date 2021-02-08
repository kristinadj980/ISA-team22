package ISA.Team22.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team22.Domain.Users.Pharmacist;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

}
