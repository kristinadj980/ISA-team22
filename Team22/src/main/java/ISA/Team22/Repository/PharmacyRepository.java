package ISA.Team22.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team22.Domain.Pharmacy.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
