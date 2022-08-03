package dk.viauc.datatier.reservation;

import dk.viauc.datatier.pet.PetService;
import dk.viauc.datatier.place.PlaceService;
import dk.viauc.datatier.reservation.dto.CreateReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final PetService petService;
    private final PlaceService placeService;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(
            PetService petService,
            PlaceService placeService,
            ReservationRepository reservationRepository
    ) {
        this.petService = petService;
        this.placeService = placeService;
        this.reservationRepository = reservationRepository;
    }

    public void addReservation(CreateReservationDTO createReservationDTO) {
        checkEntityReferences(createReservationDTO);

        Reservation reservationToCreate = new Reservation(
                petService.getPet(createReservationDTO.getPetId()).get(),
                placeService.getPlace(createReservationDTO.getPlaceId()).get(),
                createReservationDTO.getEndTime(),
                createReservationDTO.getStartTime()
        );

        reservationRepository.save(reservationToCreate);
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    private void checkEntityReferences(CreateReservationDTO reservation) {
        if (!isPetPresent(reservation.getPetId())) {
            throw new IllegalStateException("Pet not found");
        }
        if (!isPlacePresent(reservation.getPlaceId())) {
            throw new IllegalStateException("Place not found");
        }
    }

    private boolean isPetPresent(Long id) {
        return petService.isPetPresent(id);
    }

    private boolean isPlacePresent(Long id) {
        return placeService.isPlacePresent(id);
    }
}
