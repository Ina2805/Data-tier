package dk.viauc.datatier.reservation;

import dk.viauc.datatier.pet.Pet;
import dk.viauc.datatier.place.Place;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @JoinColumn(name = "pet_id")
    @NotNull
    @ManyToOne
    private Pet pet;
    @JoinColumn(name = "place_id")
    @NotNull
    @ManyToOne
    private Place place;
    @NotNull
    private LocalDateTime endTime;
    @NotNull
    private LocalDateTime startTime;

    public Reservation() { }

    public Reservation(Pet pet, Place place, LocalDateTime endTime, LocalDateTime startTime) {
        this.pet = pet;
        this.place = place;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public Reservation(Long id, Pet pet, Place place, LocalDateTime endTime, LocalDateTime startTime) {
        this.id = id;
        this.pet = pet;
        this.place = place;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", pet=" + pet +
                ", place=" + place +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                '}';
    }
}
