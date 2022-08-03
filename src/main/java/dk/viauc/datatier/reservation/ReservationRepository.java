package dk.viauc.datatier.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<List<Reservation>> findReservationsByPet_GuestOwner_Id(Long guestId);
}
