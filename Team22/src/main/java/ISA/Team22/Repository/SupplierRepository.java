package ISA.Team22.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team22.Domain.Users.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	Supplier findByEmail(String email);
}
