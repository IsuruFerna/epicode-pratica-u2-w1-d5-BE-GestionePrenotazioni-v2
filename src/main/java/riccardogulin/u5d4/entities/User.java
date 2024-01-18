package riccardogulin.u5d4.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;
	private String email;
	private int age;

	@NonNull
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_workstation",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "workstation_id"))
	private List<WorkStation> workStations;

	public User(String name, String surname, String email, int age) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
	}

	public void setWorkStations(WorkStation workStation) {
		this.workStations.add(workStation);
	}
}
