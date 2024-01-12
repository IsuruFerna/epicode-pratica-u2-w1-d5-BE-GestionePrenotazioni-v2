package riccardogulin.u5d4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkStation {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private WorkStationType workStationType;
    private int maxOccupation;
    private LocalDate occupiedDate;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToMany(mappedBy = "workStations")
    private List<User> users;

    public WorkStation(String description, WorkStationType workStationType, int maxOccupation, Office office, String occupiedDate) {
        this.description = description;
        this.workStationType = workStationType;
        this.maxOccupation = maxOccupation;
        this.office = office;
        this.occupiedDate = LocalDate.parse(occupiedDate);
    }
}
