package riccardogulin.u5d4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import riccardogulin.u5d4.entities.User;

import java.util.List;
import java.util.Optional;

@Repository // Specializzazione di @Component dedicata alle interazioni col DB
public interface UsersDAO extends JpaRepository<User, Long> {
	// Estendendo JpaRepository eredito tutti i metodi CRUD, poi posso anche decidere di aggiungerne di altri
	// Mi basta specificare nelle parentesi angolari <Classe dell'entità, Tipo dell'Id>

	// Funzionalità Custom con Derived Queries
	List<User> findBySurname(String surname); // equivalente a fare SELECT u FROM User u WHERE u.surname=:surname

	List<User> findByNameAndSurname(String name, String surname);

	List<User> findBySurnameStartingWithIgnoreCase(String partialSurname);

	List<User> findByNameIn(List<String> names);

	List<User> findByEmailNull();

	List<User> findByAgeLessThan(int age);

	Optional<User> findFirstByAgeGreaterThanEqual(int age);

	boolean existsByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.age >= 18")
	List<User> filterByMaggiorenni();

	@Query("SELECT COUNT(u) FROM User u JOIN u.workStations w WHERE w.id = :workStationId")
	int countUsersInWorkStation(@Param("workStationId") Long workStationId);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u JOIN u.workStations w WHERE w.id = :workStationId AND u.id = :userId")
	boolean checkIfTheUserIsAlreadyInWorkStation(@Param("workStationId") long workStationId, @Param("userId") long userId);


	// Link alla documentazione per le Derived Queries
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
}
