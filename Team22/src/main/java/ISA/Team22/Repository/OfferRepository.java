package ISA.Team22.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team22.Domain.Pharmacy.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
     
}
