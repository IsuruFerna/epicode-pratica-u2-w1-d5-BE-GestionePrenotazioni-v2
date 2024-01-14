package riccardogulin.u5d4.entities;

import com.github.javafaker.Weather;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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

    @Override
    public String toString() {
        return "WorkStation [id=" + id + ", " +
                "description=" + description + ", " +
                "type=" + workStationType +
                ", maxOccupation=" + maxOccupation +
                ", occupiedDate=" + occupiedDate + "]";
    }


}
