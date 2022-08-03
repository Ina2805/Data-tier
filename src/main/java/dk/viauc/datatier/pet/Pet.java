package dk.viauc.datatier.pet;

import dk.viauc.datatier.guest.Guest;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Pet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AnimalType type;
    @JoinColumn(name = "guest_id")
    @ManyToOne
    @NotNull
    Guest guestOwner;

    public Pet() { }

    public Pet(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public Pet(Long id, String name, AnimalType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public Guest getGuestOwner() {
        return guestOwner;
    }

    public void setGuestOwner(Guest guestOwner) {
        this.guestOwner = guestOwner;
    }
}

enum AnimalType {
    CAT,
    DOG,
    PARROT
}