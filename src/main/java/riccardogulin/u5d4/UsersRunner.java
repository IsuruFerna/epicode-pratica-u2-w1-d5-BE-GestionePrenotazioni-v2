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
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5d4Application.class);ù
//		officeService.save(ctx.getBean("of1", Office.class));
//		System.out.println(ctx.getBean("of1", Office.class));

		Faker faker = new Faker();
		Office of1 = new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());
		Office of2 = new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());
		Office of3 = new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());
//		officeService.save(of1);
//		officeService.save(of2);
//		officeService.save(of3);

//		to handle
//		try {
//			officeService.findByCity("North Alberthabury");
//		} catch (LazyInitializationException ex) {
//			System.err.println(ex.getMessage());
//		}

		try {
//			Office of1Db = officeService.findById(1L);
//			Office of2Db = officeService.findById(2L);

//			WorkStation ws1 = new WorkStation("descritption", WorkStationType.MEETING_ROOM, 20, of1Db);
//			WorkStation ws2 = new WorkStation("descritption", WorkStationType.OPEN_SPACE, 10, of1Db);
//			WorkStation ws3 = new WorkStation("descritption", WorkStationType.PRIVATE, 6, of2Db);
//			workStationService.save(ws1);
//			workStationService.save(ws2);
//			workStationService.save(ws3);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}






//		Random rndm = new Random();
//		System.out.println("-------------------- SAVE ----------------------");
//		User user = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(0, 100));
//		usersService.saveUser(user);
//
//		System.out.println("-------------------- FIND BY ID ----------------------");
//		try {
//			System.out.println(usersService.findById(1));
//			System.out.println(usersService.findById(24));
//		} catch (Exception ex) {
//			System.err.println(ex.getMessage());
//		}
//
//
//		System.out.println("-------------------- FIND ALL ----------------------");
//		usersService.findAll().forEach(System.out::println);
//
//		System.out.println("-------------------- FIND BY ID AND DELETE ----------------------");
//		try {
//			usersService.findByIdAndDelete(52);
//		} catch (Exception ex) {
//			System.err.println(ex.getMessage());
//		}
//
//		System.out.println("-------------------- FIND BY ID AND UPDATE ----------------------");
//		try {
//			User updatedUser = new User("Giacomo", "Poretti", "giacomo@gmail.com", 88);
//			//usersService.findByIdAndUpdate(2, updatedUser);
//		} catch (Exception ex) {
//			System.err.println(ex.getMessage());
//		}
//
//
//		System.out.println("-------------------- FIND BY SURNAME ----------------------");
//		usersService.filterBySurname("Baglio").forEach(System.out::println);
//
//		System.out.println("-------------------- FIND BY NAME AND SURNAME ----------------------");
//		usersService.filterByNameAndSurname("Aldo", "Baglio").forEach(System.out::println);
//
//		System.out.println("-------------------- FIND BY SURNAME STARTING WITH ----------------------");
//		usersService.filterBySurnameStartingWith("B").forEach(System.out::println);
//
//		System.out.println("-------------------- FIND BY LIST OF NAMES ----------------------");
//
//		usersService.filterByListOfNames(List.of("Aldo", "Giovanni")).forEach(System.out::println);
//
//		System.out.println("-------------------- FIND BY AGE ----------------------");
//
//		usersService.filterByAgeLessThan(40).forEach(System.out::println);

//		ctx.close();

	}
}
