package udem.edu.co.heroes.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="heroe")
public class Heroe {
    @Id
    private String name;

    @OneToMany(mappedBy = "heroe", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Poder> poder;

    public Heroe(String spiderMan, String misiles) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Poder> getPoder() {
        return poder;
    }

    public void setPoder(List<Poder> poder) {
        this.poder = poder;
    }
}
