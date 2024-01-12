package riccardogulin.u5d4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u5d4.entities.Office;

import java.util.List;

@Repository
public interface OfficeDAO extends JpaRepository<Office, Long> {
    List<Office> findByCity(String city);

}
