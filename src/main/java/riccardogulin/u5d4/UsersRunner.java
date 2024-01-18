package riccardogulin.u5d4;

import com.github.javafaker.Faker;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import riccardogulin.u5d4.dao.OfficeService;
import riccardogulin.u5d4.dao.UsersService;
import riccardogulin.u5d4.dao.WorkStationService;
import riccardogulin.u5d4.entities.Office;
import riccardogulin.u5d4.entities.User;
import riccardogulin.u5d4.entities.WorkStation;
import riccardogulin.u5d4.entities.WorkStationType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Autowired
	OfficeService officeService;

	@Autowired
	WorkStationService workStationService;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker();
		Random rndm = new Random();

/*		Office of1 = new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());
		Office of2 = new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());
		Office of3 = new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());

		officeService.save(of1);
		officeService.save(of2);
		officeService.save(of3);*/

	/*	WorkStation ws1 = new WorkStation().builder()
				.description("WS1")
				.maxOccupation(rndm.nextInt(5, 30))
				.office(officeService.findById(rndm.nextLong(16, 24)))
				.workStationType(WorkStationType.PRIVATE).build();

		WorkStation ws2 = new WorkStation().builder()
				.description("WS1")
				.maxOccupation(rndm.nextInt(5, 30))
				.office(officeService.findById(rndm.nextLong(16, 24)))
				.workStationType(WorkStationType.OPEN_SPACE).build();

		WorkStation ws3 = new WorkStation().builder()
				.description("WS1")
				.maxOccupation(rndm.nextInt(5, 30))
				.office(officeService.findById(rndm.nextLong(16, 24)))
				.workStationType(WorkStationType.MEETING_ROOM).build();

		WorkStation ws4 = new WorkStation().builder()
				.description("WS1")
				.maxOccupation(rndm.nextInt(5, 30))
				.office(officeService.findById(rndm.nextLong(16, 24)))
				.workStationType(WorkStationType.OPEN_SPACE).build();

		WorkStation ws5 = new WorkStation().builder()
				.description("WS1")
				.maxOccupation(rndm.nextInt(5, 30))
				.office(officeService.findById(rndm.nextLong(16, 24)))
				.workStationType(WorkStationType.MEETING_ROOM).build();

		workStationService.save(ws1);
		workStationService.save(ws2);
		workStationService.save(ws3);
		workStationService.save(ws4);
		workStationService.save(ws5);*/

/*		User u1 = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(18, 60));
		User u2 = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(18, 60));
		User u3 = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(18, 60));
		User u4 = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(18, 60));
		User u5 = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(18, 60));

		usersService.saveUser(u1);
		usersService.saveUser(u2);
		usersService.saveUser(u3);
		usersService.saveUser(u4);
		usersService.saveUser(u5);*/



//		System.out.println("******* All offices *********");
//		List<Office> allOffices = officeService.getAllOffices();
//		allOffices.forEach(System.out::println);
//
//		officeService.printAllOffices();
//		officeService.printOfficesByCity("eugeniemouth");

		// all available workstations
		workStationService.availableWorkstations();

		// not available workstations by date
		workStationService.notAvailableWorkStationsByDate(LocalDate.now());

		// workstation by type
		workStationService.WorkStationByType(WorkStationType.OPEN_SPACE);

		// book workstation
		usersService.findAll();

		// book workstation
		usersService.bookWorkStation(2, 1, LocalDate.parse("2022-03-08"));

	}
}
