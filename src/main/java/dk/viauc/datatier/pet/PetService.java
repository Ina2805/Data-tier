package dk.viauc.datatier.pet;

import dk.viauc.datatier.guest.Guest;
import dk.viauc.datatier.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final GuestRepository guestRepository;
    private final PetRepository petRepository;

    @Autowired
    public PetService(GuestRepository guestRepository, PetRepository petRepository) {
        this.guestRepository = guestRepository;
        this.petRepository = petRepository;
    }

    public void addPet(Pet pet, Long guestId) {
        Optional<Guest> guestOptional = guestRepository.findById(guestId);

        if (!guestOptional.isPresent()) {
            throw new IllegalStateException("Guest not found");
        }

        pet.setGuestOwner(guestOptional.get());
        petRepository.save(pet);
    }

    public List<Pet> getPets(Long guestId) {
        Optional<List<Pet>> guestPetsOptional = petRepository.findPetsByGuestOwner_Id(guestId);

        return guestPetsOptional.get();
    }
}
