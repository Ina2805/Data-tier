package dk.viauc.datatier.place;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<List<Place>> findPlacesByHostOwner_Id(Long hostId);
}
