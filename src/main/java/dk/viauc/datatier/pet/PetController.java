package dk.viauc.datatier.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/guests/{guestId}/pets")
@RestController
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public void createPet(
            @PathVariable("guestId") long guestId,
            @Valid
            @RequestBody
            Pet pet
    ) {
        petService.addPet(pet, guestId);
    }

    @GetMapping
    public List<Pet> getPets(@PathVariable("guestId") long guestId) {
        return petService.getPets(guestId);
    }
}
