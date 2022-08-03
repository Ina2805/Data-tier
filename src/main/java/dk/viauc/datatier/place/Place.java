package dk.viauc.datatier.place;

import dk.viauc.datatier.host.Host;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @JoinColumn(name = "host_id")
    @ManyToOne
    @NotNull
    Host hostOwner;

    public Place() { }

    public Place(String address, String city, String country, Host hostOwner) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.hostOwner = hostOwner;
    }

    public Place(Long id, String address, String city, String country, Host hostOwner) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.hostOwner = hostOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Host getHostOwner() {
        return hostOwner;
    }

    public void setHostOwner(Host hostOwner) {
        this.hostOwner = hostOwner;
    }
}
