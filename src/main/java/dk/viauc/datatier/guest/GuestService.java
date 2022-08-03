package dk.viauc.datatier.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void addGuest(Guest guest) {
        Optional<Guest> guestOptional = guestRepository.findGuestByEmail(guest.getEmail());

        if (guestOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }

        guestRepository.save(guest);
    }

    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    public boolean isGuestPresent(Long id) {
        return guestRepository.existsById(id);
    }
}
