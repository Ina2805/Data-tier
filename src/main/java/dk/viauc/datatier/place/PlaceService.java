package dk.viauc.datatier.place;

import dk.viauc.datatier.host.Host;
import dk.viauc.datatier.host.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    private final HostRepository hostRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(HostRepository hostRepository, PlaceRepository placeRepository) {
        this.hostRepository = hostRepository;
        this.placeRepository = placeRepository;
    }

    public void addPlace(Place place, Long hostId) {
        Optional<Host> hostOptional = hostRepository.findById(hostId);

        if (!hostOptional.isPresent()) {
            throw new IllegalStateException("Host not found");
        }

        place.setHostOwner(hostOptional.get());
        placeRepository.save(place);
    }

    public Optional<Place> getPlace(Long placeId) {
        return placeRepository.findById(placeId);
    }

    public List<Place> getPlaces(Long hostId) {
        Optional<List<Place>> hostPlacesOptional = placeRepository.findPlacesByHostOwner_Id(hostId);

        return hostPlacesOptional.get();
    }

    public boolean isPlacePresent(Long id) {
        return placeRepository.existsById(id);
    }
}
