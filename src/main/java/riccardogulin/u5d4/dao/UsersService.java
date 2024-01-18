package riccardogulin.u5d4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riccardogulin.u5d4.entities.User;
import riccardogulin.u5d4.entities.WorkStation;
import riccardogulin.u5d4.exceptions.ItemNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service // Specializzazione di @Component
@Slf4j
public class UsersService {

	@Autowired
	private UsersDAO usersDAO;

	@Autowired
	private WorkStationService workStationService;

	public void saveUser(User user) {
		// eventuale logica addizionale custom tipo aggiunta campi extra allo user, controlli vari
		if (user.getName().length() < 2) throw new RuntimeException("Il nome non può essere più corto di 2");

		// Devo usare UsersDAO per salvare lo user a db, essendo UsersService un Component
		// ed essendo UsersDAO anch'esso un Component, come posso ottenere qua dentro
		// un riferimento a UsersDAO?
		usersDAO.save(user);
		log.info("User salvato correttamente!");
	}

	public void bookWorkStation(long userId, long workstationId, LocalDate localDate) {
		WorkStation workStation = workStationService.findById(workstationId);
		if(workStation.getOccupiedDate() == null
				|| workStation.getMaxOccupation() > usersDAO.countUsersInWorkStation(workstationId)
				&& !usersDAO.checkIfTheUserIsAlreadyInWorkStation(workstationId, userId)) {
			User user = this.findById(userId);
			user.setWorkStations(workStation);
			workStation.setOccupiedDate(localDate);
			this.saveUser(user);
			workStationService.save(workStation);
			System.out.println("workstation: " + workStation.getId() + " booked by " + user.getName());
		} else {
			System.out.println("Work station already occupied!");
		}
	}

	public int countUsersInWorkStation(long workStationId) {
		return usersDAO.countUsersInWorkStation(workStationId);
	}

	public boolean checkIfTheUserIsAlreadyInWorkStation(long workstationId, long userId) {
		return usersDAO.checkIfTheUserIsAlreadyInWorkStation(workstationId, userId);
	}

	public User findById(long id) throws ItemNotFoundException {
	/*	Optional<User> userOptional = usersDAO.findById(id);

		if (userOptional.isPresent()) {
			return userOptional.get(); // se abbiamo la certezza che userOptional non sia null, con get restituiuamo l'oggetto
		} else {
			throw new ItemNotFoundException(id);
		}*/

		return usersDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id)); // Alternativa molto più compatta al codice di sopra
	}

	public void findAll() {
		 usersDAO.findAll().forEach(System.out::println);
	}

	public void findByIdAndDelete(long id) {
		User found = this.findById(id);
		usersDAO.delete(found);
		log.info("User con id " + id + " eliminato con successo!");
	}

	public void findByIdAndUpdate(long id, User user) {
		// 1. Cerco lo user per id
		User found = this.findById(id);
		// 2. Aggiorno i dati con quelli passati come parametro di questo metodo
		found.setAge(user.getAge());
		found.setName(user.getName());
		found.setSurname(user.getSurname());
		found.setEmail(user.getEmail());
		// 3. Risalvo lo user così modificato
		usersDAO.save(found);
		log.info("User con id " + id + " aggiornato con successo!");
	}

	public long count() {
		return usersDAO.count();
	}

	public List<User> filterBySurname(String surname) {
		return usersDAO.findBySurname(surname);
	}

	public List<User> filterByNameAndSurname(String name, String surname) {
		return usersDAO.findByNameAndSurname(name, surname);
	}

	public List<User> filterBySurnameStartingWith(String partialSurname) {
		return usersDAO.findBySurnameStartingWithIgnoreCase(partialSurname);
	}

	public List<User> filterByListOfNames(List<String> names) {
		return usersDAO.findByNameIn(names);
	}

	public List<User> filterByAgeLessThan(int age) {
		return usersDAO.findByAgeLessThan(age);
	}
}
