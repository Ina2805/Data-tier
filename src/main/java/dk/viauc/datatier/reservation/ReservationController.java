package dk.viauc.datatier.reservation;

import dk.viauc.datatier.reservation.dto.CreateReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/reservations")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void createReservation(
            @RequestBody
            @Valid
            CreateReservationDTO createReservationDTO
    ) {
        reservationService.addReservation(createReservationDTO);
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }
}
