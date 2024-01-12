package riccardogulin.u5d4.entities;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    Faker faker = new Faker();

    @Bean(name = "of1")
    public Office of1() {
        return new Office(faker.company().name(), faker.address().fullAddress(), faker.address().city());
    }
}
