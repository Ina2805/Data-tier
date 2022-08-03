package dk.viauc.datatier.host;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Host {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String password;

    public Host() { }

    public Host(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Host(Long id, String email, String name, String password) {
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
