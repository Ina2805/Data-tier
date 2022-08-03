package dk.viauc.datatier.guest;

import dk.viauc.datatier.pet.Pet;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Guest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pet> pet;

    public Guest() { }

    public Guest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Guest(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
