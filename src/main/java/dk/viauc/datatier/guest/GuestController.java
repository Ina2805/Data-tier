package dk.viauc.datatier.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/guests")
@RestController
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public void createGuest(@RequestBody @Valid Guest guest) {
        guestService.addGuest(guest);
    }

    @GetMapping
    public List<Guest> getGuests() {
        return guestService.getGuests();
    }
}
