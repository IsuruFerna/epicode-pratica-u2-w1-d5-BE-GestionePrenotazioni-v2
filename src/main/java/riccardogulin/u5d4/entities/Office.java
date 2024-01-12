package riccardogulin.u5d4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private Set<WorkStation> workStations;

    public Office(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
