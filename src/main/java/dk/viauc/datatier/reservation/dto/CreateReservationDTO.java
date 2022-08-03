package dk.viauc.datatier.reservation.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateReservationDTO {
    @NotNull
    private Long petId;
    @NotNull
    private Long placeId;
    @NotNull
    private LocalDateTime endTime;
    @NotNull
    private LocalDateTime startTime;

    public CreateReservationDTO() { }

    public CreateReservationDTO(Long petId, Long placeId, LocalDateTime endTime, LocalDateTime startTime) {
        this.petId = petId;
        this.placeId = placeId;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
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
}
