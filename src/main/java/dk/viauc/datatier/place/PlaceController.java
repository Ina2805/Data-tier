package dk.viauc.datatier.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/hosts/{hostId}/places")
@RestController
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public void createPlace(
            @PathVariable("hostId") Long hostId,
            @RequestBody
            @Valid
            Place place
    ) {
        placeService.addPlace(place, hostId);
    }

    @GetMapping
    public List<Place> getOwnerPlaces(@PathVariable("hostId") Long hostId) {
        return placeService.getPlaces(hostId);
    }
}
